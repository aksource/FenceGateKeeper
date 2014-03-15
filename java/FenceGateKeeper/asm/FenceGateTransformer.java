package FenceGateKeeper.asm;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.launchwrapper.IClassTransformer;
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
            System.out.println("Start FenceGate Transform");
            ClassReader classReader = new ClassReader(basicClass);
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            classReader.accept(new CustomVisitor(name, classWriter), 8);
            basicClass = classWriter.toByteArray();
            System.out.println("Finish FenceGate Transform");
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
        static final String targetMethodName = "func_149655_b";
        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (targetMethodName.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))) {
                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                System.out.println("insert false return");
                mv.visitInsn(ICONST_0);
                mv.visitInsn(IRETURN);
                return mv;
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }
}
