package src;

/**
 * Created by GreenyNeko on 11.12.2014.
 */

import android.graphics.Paint;

import com.kod.knightsofdrakonur.framework.Game;
import com.kod.knightsofdrakonur.framework.Graphics;
import com.kod.knightsofdrakonur.framework.Input.TouchEvent;
import com.kod.knightsofdrakonur.framework.Screen;

import java.util.List;
import java.util.Locale;

import util.Math;

public class CharacterScreen extends Screen
{
    public int ticks = 0;

    public CharacterScreen(Game game)
    {
        super(game);
    }

    @Override
    public void update(float deltaTime)
    {
        int screenH = game.getGraphics().getHeight(), screenW = game.getGraphics().getWidth();
        Graphics graphics = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        for(int i = 0; i < touchEvents.size(); i++)
        {
            TouchEvent touchEvent = touchEvents.get(i);
            if(touchEvent.type == TouchEvent.TOUCH_UP)
            {
                if(Math.inBoundary(touchEvent, 0, (int)(screenH * 0.12), 160, 256))
                {
                    game.setScreen(new AttributeScreen(game));
                }
                else if(Math.inBoundary(touchEvent, 0, (int)(screenH * 0.37), 160, 256))
                {
                    game.setScreen(new SkillScreen(game));
                }
                else if(Math.inBoundary(touchEvent, 0, (int)(screenH * 0.62), 160, 256))
                {
                    game.setScreen(new EquipScreen(game));
                }
            }
        }
    }

    @Override
    public void paint(float deltaTime)
    {
        int screenH = game.getGraphics().getHeight(), screenW = game.getGraphics().getWidth();
        Graphics graphics = game.getGraphics();
        graphics.clearScreen(0x459AFF);

        graphics.drawImage(Assets.ui_shield, -32, (int)(screenH * 0.12));
        graphics.drawImage(Assets.ui_shield, -32, (int)(screenH * 0.37));
        graphics.drawImage(Assets.ui_shield, -32, (int)(screenH * 0.62));

        graphics.drawImage(Assets.ui_iconAttributes, 16, (int)(screenH * 0.12) + 48);
        graphics.drawImage(Assets.ui_iconSkills, 16, (int)(screenH * 0.37) + 48);
        graphics.drawImage(Assets.ui_iconEquip, 16, (int)(screenH * 0.62) + 48);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {

    }

    @Override
    public void onBackPressed()
    {
        game.setScreen(new MenuScreen(game));
    }
}
