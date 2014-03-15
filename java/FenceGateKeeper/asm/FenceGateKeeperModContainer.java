package FenceGateKeeper.asm;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import java.util.Arrays;

/**
 * Created by A.K. on 14/03/15.
 */
public class FenceGateKeeperModContainer extends DummyModContainer{
    public FenceGateKeeperModContainer() {
        super(new ModMetadata());

        ModMetadata meta = getMetadata();
        meta.modId = "FenceGateKeeper";
        meta.name = "FenceGateKeeper";
        meta.version = "1.0.0";
        meta.authorList = Arrays.asList("takanasayo", "A.K.");
        meta.description = "Prevent mob to go out from fencegate";
        meta.url = "";
        meta.credits = "";
        this.setEnabledState(true);
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
}
