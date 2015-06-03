package FenceGateKeeper.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Created by A.K. on 14/03/15.
 */
public class FenceGateKeeperCorePlugin implements IFMLLoadingPlugin{
    public static Logger logger = LogManager.getLogger("FenceGateKeeper");
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
