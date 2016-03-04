package net.minecraft.src;

import java.util.Random;

import org.lwjgl.input.Keyboard;

public class GuiCustomizeWorld extends GuiScreen {
    public GuiCustomizeWorld(GuiScreen guiscreen)
    {
        field_22131_a = guiscreen;
    }

    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        Keyboard.enableRepeatEvents(true);
        controlList.clear();
        controlList.add(new GuiButton(0, width / 2 - 100, 76 + 12, 100, 20, "On"));
        controlList.add(new GuiButton(2, width / 2 , 76 + 12, 100, 20, "Short"));
        controlList.add(new GuiButton(3, width / 2 - 100, 106 + 12, 100, 20, "Structures On"));
        controlList.add(new GuiButton(4, width / 2 , 106 + 12, 100, 20, "Summer"));
        controlList.add(new GuiButton(1, width / 2 - 100, 136 + 12, "Finish"));
    }

    public static String generateUnusedFolderName(ISaveFormat isaveformat, String s)
    {
        for(; isaveformat.func_22173_b(s) != null; s = (new StringBuilder()).append(s).append("-").toString()) { }
        return s;
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(!guibutton.enabled)
        {
            return;
        }
        if(guibutton.id == 1)
        {
            mc.displayGuiScreen(field_22131_a);
        } else
        if(guibutton.id == 0)
        {
        	if (season == 1){
        		season = -1;
            } else if (season == -1){
            	season = 5;
            } else if (season == 5){
            	season = 1;
            }
        }
        if(guibutton.id == 2)
        {
        	timescale++;
        	if (timescale == 7){
        		timescale = 30;
        	}
        	if (timescale > 30){
        		timescale = 2;
        	}
        }
        
        if (guibutton.id == 3){
        	structures ^= true;
        }
        if (guibutton.id == 4){
        	seasonToStart++;
        	if (seasonToStart == 4){
        		seasonToStart = 0;
        	}
        }
    }

    protected void mouseClicked(int i, int j, int k)
    {
        super.mouseClicked(i, j, k);
        
    }

    public void drawScreen(int i, int j, float f)
    {
        if (season == 1){
        	((GuiButton) controlList.get(0)).displayString = "On";
        } else if (season == -1){
        	((GuiButton) controlList.get(0)).displayString = "Off";
        } else if (season == 5){
        	((GuiButton) controlList.get(0)).displayString = "Winter Mode";
        }
        if (timescale == 2){
        	((GuiButton) controlList.get(1)).displayString = "Instant";
        } else if (timescale == 3){
        	((GuiButton) controlList.get(1)).displayString = "Short";
        } else if (timescale == 4){
        	((GuiButton) controlList.get(1)).displayString = "Medium";
        } else if (timescale == 5){
        	((GuiButton) controlList.get(1)).displayString = "Long";
        } else if (timescale == 6){
        	((GuiButton) controlList.get(1)).displayString = "Epic";
        } else if (timescale == 30){
        	((GuiButton) controlList.get(1)).displayString = "Eternal";
        }
        
        if (structures){
        	((GuiButton) controlList.get(2)).displayString = "Structures On";
        } else{
        	((GuiButton) controlList.get(2)).displayString = "Structures Off";
        }
        
        if (seasonToStart == 0){
        	((GuiButton) controlList.get(3)).displayString = "Spring";
        } else if (seasonToStart == 1){
        	((GuiButton) controlList.get(3)).displayString = "Summer";
        } else if (seasonToStart == 2){
        	((GuiButton) controlList.get(3)).displayString = "Autumn";
        } else if (seasonToStart == 3){
        	((GuiButton) controlList.get(3)).displayString = "Winter";
        }
        
        if (season == 5 || season == -1){
        	((GuiButton) controlList.get(3)).enabled = false;
        } else{
        	((GuiButton) controlList.get(3)).enabled = true;
        }
        
        drawDefaultBackground();
        drawCenteredString(fontRenderer, "Customize World", width / 2, (height / 4 - 60) + 20, 0xffffff);
        drawCenteredString(fontRenderer, "Seasons", width / 2 - 50,  66 + 12, 0xffffff);
        drawCenteredString(fontRenderer, "Timescale", width / 2 + 50,  66 + 12, 0xffffff);
        super.drawScreen(i, j, f);
    }

    public void selectNextField()
    {
    }
    
    public static int season = 1;
    public static int timescale = 4;
    
    public static boolean structures = false;
    
    public static int seasonToStart = 1;

    private GuiScreen field_22131_a;
}