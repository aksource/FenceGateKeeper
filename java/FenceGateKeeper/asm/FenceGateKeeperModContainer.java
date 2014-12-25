package FenceGateKeeper.asm;

import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;

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
        meta.version = "@VERSION@";
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
