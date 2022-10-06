package ch8인터페이스;

public class Audio implements RemoteControl {

		private int volume;
		
		@Override
		public void turnOn() {System.out.println("Audio 켭니다.");}
		@Override
		public void turnOff() {System.out.println("Audio 끕니다.");}
		@Override
		public void setVolume(int volume) {
			if( volume > RemoteControl.MAX_VLOUME) {
				this.volume = RemoteControl.MAX_VLOUME;
			}else if ( volume < RemoteControl.MIN_VLOUME) {
				this.volume = RemoteControl.MIN_VLOUME;
			}else {
				this.volume = volume;
			}
			System.out.println("현재 Audio 볼륨 : " + this.volume);
		}
}
