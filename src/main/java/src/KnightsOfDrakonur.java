package src;

/**
 * Created by GreenyNeko on 11.12.2014.
 */

import com.kod.knightsofdrakonur.framework.Screen;

import java.util.Locale;

import impl.AndroidGame;

public class KnightsOfDrakonur extends AndroidGame
{
    @Override
    public Screen getInitScreen()
    {
        this.setLocale(Locale.ENGLISH);
        return new LoadResources(this);
    }
}
