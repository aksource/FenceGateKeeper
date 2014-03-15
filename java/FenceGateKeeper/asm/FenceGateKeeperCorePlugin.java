package FenceGateKeeper.asm;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.io.File;
import java.util.Map;

/**
 * Created by A.K. on 14/03/15.
 */
@IFMLLoadingPlugin.MCVersion("1.7.2")
public class FenceGateKeeperCorePlugin implements IFMLLoadingPlugin{
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"FenceGateKeeper.asm.FenceGateTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "FenceGateKeeper.asm.FenceGateKeeperModContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
