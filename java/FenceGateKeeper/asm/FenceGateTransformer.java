package FenceGateKeeper.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import org.objectweb.asm.*;

/**
 * Created by A.K. on 14/03/15.
 */
public class FenceGateTransformer implements IClassTransformer, Opcodes{
    private static final String TARGETCLASSNAME = "net.minecraft.block.BlockFenceGate";
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (!FMLLaunchHandler.side().isClient() || !TARGETCLASSNAME.equals(transformedName)) {return basicClass;}
        try {
            FenceGateKeeperCorePlugin.logger.info("Start FenceGate Transform");
            ClassReader classReader = new ClassReader(basicClass);
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            classReader.accept(new CustomVisitor(name, classWriter), 8);
            basicClass = classWriter.toByteArray();
            FenceGateKeeperCorePlugin.logger.info("Finish FenceGate Transform");
        } catch (Exception e) {
            throw new RuntimeException("failed : FenceGateTransformer loading", e);
        }
        return basicClass;
    }

    class CustomVisitor extends ClassVisitor
    {
        String owner;
        String transformedName;
        public CustomVisitor(String owner ,ClassVisitor cv)
        {
            super(Opcodes.ASM4,cv);
            this.owner = owner;
        }
        static final String targetMethodName = "func_176205_b";//isPassable(old:getBlocksMovement)
        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (targetMethodName.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))) {
                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                FenceGateKeeperCorePlugin.logger.info("insert false return");
                mv.visitInsn(ICONST_0);
                mv.visitInsn(IRETURN);
                return mv;
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }
}
