package com.ypp.plugin;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @Description:
 * @Author: zouji
 * @CreateDate: 2024/2/2 19:07
 */
public class DemoMethodVisitor extends MethodVisitor {


    public DemoMethodVisitor(int api) {
        super(api);
    }

    public DemoMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
//        mv.visitLdcInsn("TAG");
//        mv.visitLdcInsn("===== This is just a test message =====");
//        mv.visitMethodInsn(
//                Opcodes.INVOKESTATIC,
//                "android/util/Log",
//                "e",
//                "(Ljava/lang/String;Ljava/lang/String;)I",
//                false
//        );
//        mv.visitInsn(Opcodes.POP);

    }
}
