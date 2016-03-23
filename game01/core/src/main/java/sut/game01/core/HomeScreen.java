package sut.game01.core;

import static playn.core.PlayN.*;
import react.UnitSlot;
import playn.core.Font;
import tripleplay.game.*;
import tripleplay.ui.*;
import tripleplay.ui.layout.*;

import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;
/**
 * Created by Administrator on 23/3/2559.
 */
public class HomeScreen extends UIScreen {
    public static final Font TITLE_FONT = graphics().createFont(
            "Helvetica",
            Font.Style.PLAIN,
            24);

    private final ScreenStack ss;
    private final TestScreen testScreen;
    private Root root;

    public HomeScreen(ScreenStack ss){
        this.ss = ss;
        this.testScreen = new TestScreen(ss);
    }

    @Override
    public void wasShown(){
        super.wasShown();
        root = iface.createRoot(
            AxisLayout.vertical().gap(15),
            SimpleStyles.newSheet(), layer);

        root.addStyles(Style.BACKGROUND
            .is(Background.bordered(0xFFCCCCCC, 0xFF99CCFF, 5)
            .inset(5 ,10)));
        root.setSize(width(), height());

        root.add(new Label("Even Dri Pro")
            .addStyles(Style.FONT.is(HomeScreen.TITLE_FONT)));

        root.add(new Button("Start").onClick(new UnitSlot(){
            public void onEmit(){
                ss.push(testScreen);
            }
        }));

    }

}
