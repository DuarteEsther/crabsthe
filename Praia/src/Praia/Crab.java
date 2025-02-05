package Praia;

	import java.awt.Graphics;
	import java.awt.Rectangle;
	import java.awt.image.BufferedImage;

import catch_crab.Game;
import catch_crab.Smoke;
import catch_crab.Sound;

	public class Crab {
		
		public double x,y,dx,dy;
		public double spd = 4;
		public static BufferedImage[] crabSprite;
		public int curFrames = 0, maxFrames =10, maxAnim =2, curAnim =0;
		
		public Crab(int x , int y) {
			this.x = x;
			this.y = y;
			double radius = Math.atan2((Game.HEIGHT/2 - 20)- y, (Game.WIDTH/2 - 20) - x);
			this.dx = Math.cos(radius);
			this.dy = Math.sin(radius);
			crabSprite = new BufferedImage[2];
			crabSprite [0] = Game.spritesheet.getSprite(0, 0);
			crabSprite [1] = Game.spritesheet.getSprite(16, 0);
			//TODO CALCULO DO TUBO
		}

		public void update() {
			x+=(dx*spd);
			y+=(dy*spd);
			if(new Rectangle((int) x, (int) y, 40, 40).intersects(Game.MaskBuraco)) {
				Game.crabs.remove(this);
				return;
			}
			curFrames++;
			if(curFrames == maxFrames) {
				curAnim++;
				if(curAnim == maxAnim) {
					curAnim =0;
				}
				curFrames = 0;
			}
			
			//verificar colisao com pontos do mouse
			VerificaColisao();
			}
			
			public void VerificaColisao() {
				if(Game.isPressed) {
					Game.isPressed = false;
					
				if(Game.mx >= x && Game.mx <= x + 40) {
					if(Game.my >= y && Game.my <= y + 40) {
						Game.crabs.remove(this);
						Sound.explo.play();
						Game.score++;
						Game.smokes.add(new Smoke((int)x, (int)y));
						return;
					}
				}
				
				}
		}
		
		
		public void render(Graphics g) {
			g.drawImage(crabSprite[curAnim],(int)x,(int)y,40,40, null);
		//	g.setColor(Color.red);    
		//	g.fillRect((int)x, (int)y, 40, 40);
			
		}
	}


