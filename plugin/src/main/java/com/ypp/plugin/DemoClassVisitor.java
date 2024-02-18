package com.ypp.plugin;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @Description:
 * @Author: zouji
 * @CreateDate: 2024/2/2 18:14
 */
public class DemoClassVisitor extends ClassVisitor {

    private String className = null;


    public DemoClassVisitor(int api) {
        super(api);
    }

    public DemoClassVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        className = name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
//   com/ypp/asmdemoplugin/MainActivity.kt
        if (className.equals("NewYuerHomeActivity")) {
//            if (name.equals("onCreate")) {
                return new DemoMethodAdapter(Opcodes.ASM6, methodVisitor, access, name, desc);
//            }
        }
        return methodVisitor;
    }
}
