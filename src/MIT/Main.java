package MIT;

import MIT.content.MITBlocks;
import arc.util.Log;
import mindustry.ctype.ContentList;
import mindustry.mod.Mod;

public class Main extends Mod {

    private static final ContentList[] content = {
            new MITBlocks()
    };

    @Override
    public void init(){
        System.out.println("hi");
        Log.info("hihi");
    }

    @Override
    public void loadContent(){
        for (ContentList contentList : content) {
            contentList.load();
        }
    }


}
