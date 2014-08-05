package FenceGateKeeper.asm;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by A.K. on 14/03/15.
 */
public class FenceGateKeeperCorePlugin implements IFMLLoadingPlugin{
    public static Logger logger = Logger.getLogger("FenceGateKeeper");
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
