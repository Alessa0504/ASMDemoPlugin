package com.ypp.plugin;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

/**
 * @Description:
 * @Author: zouji
 * @CreateDate: 2024/2/3 19:52
 */
public class DemoMethodAdapter extends AdviceAdapter {

    protected DemoMethodAdapter(int api, MethodVisitor mv, int access, String name, String desc) {
        super(api, mv, access, name, desc);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        // 插入 long startTime = System.currentTimeMillis();
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitVarInsn(LSTORE, 2);

//        mv.visitVarInsn(ALOAD, 0);
//        mv.visitInsn(LCONST_0);
//        mv.visitFieldInsn(PUTFIELD, "Test", "startTime", "J");
//        Label label1 = new Label();
//        mv.visitLabel(label1);
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        // 插入 long endTime = System.currentTimeMillis();
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitVarInsn(LSTORE, 3);
//        Label label2 = new Label();
//        mv.visitLabel(label2);

        // 插入 System.out.println("exe method time="+(endTime-startTime));
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
        mv.visitLdcInsn("exe method time=");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
        mv.visitVarInsn(LLOAD, 3);
        mv.visitVarInsn(LLOAD, 2);
        mv.visitInsn(LSUB);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//        Label label3 = new Label();
//        mv.visitLabel(label3);
    }
}
