package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.util.Clock;
import tripleplay.game.ScreenStack;

public class MyGame extends Game.Default {

	public static final int UPDATE_RATE = 25;
    private ScreenStack ss = new ScreenStack();
    protected final Clock.Source clock = new Clock.Source(UPDATE_RATE);

  public MyGame() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
  	ss.push(new HomeScreen(ss));
  }

  @Override
  public void update(int delta) {
  	ss.update(delta);
  }

  @Override
  public void paint(float alpha) {
    clock.paint(alpha);
    ss.paint(clock);
  }
}
