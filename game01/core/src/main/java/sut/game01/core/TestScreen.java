package sut.game01.core;

import static playn.core.PlayN.*;
import playn.core.Font;
import tripleplay.game.UIScreen;
import tripleplay.ui.*;
import tripleplay.ui.layout.*;
import playn.core.Game;
import playn.core.*;

import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;
/**
 * Created by Administrator on 23/3/2559.
 */
public class TestScreen extends UIScreen {
   
    private final ScreenStack ss;
    private final ImageLayer bg;
    private final ImageLayer backButton;

    public TestScreen(final ScreenStack ss){
        this.ss = ss;
        Image bgImage = assets().getImage("images/bg.png");
        this.bg = graphics().createImageLayer(bgImage);
        this.layer.add(bg);

        Image backImage = assets().getImage("images/back1.png");
        this.backButton = graphics().createImageLayer(backImage);
        backButton.setTranslation(10,10);

        backButton.addListener(new Mouse.LayerAdapter(){
            @Override
            public void onMouseUp(Mouse.ButtonEvent event){
                ss.remove(ss.top());
            }
        });

    }

    @Override
    public void wasShown(){
        super.wasShown();
        this.layer.add(bg);
        this.layer.add(backButton);



    }

}
