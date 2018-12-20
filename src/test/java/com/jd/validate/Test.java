package com.jd.validate;

import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import sun.management.HotSpotDiagnostic;

import javax.management.MBeanServerConnection;
import javax.management.openmbean.CompositeData;
import java.lang.management.*;
import java.lang.reflect.Field;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static java.lang.management.ManagementFactory.getPlatformMXBean;

public class Test {
    public static void main(String[] args) throws Exception {

        // System.getProperties().list(System.out);

        // getMemoryInfo();

        // getRunTimeInfo();

        // getOperatingSystemInfo();

        // getThreadInfo();

        // getCompilationInfo();

        // getMemoryPool();

        // getGarbageCollectorInfo();

        // getOtherInfo();
        // addLibraryDir("/abcdefghigklmn");

        MBeanServerConnection msc = ManagementFactory.getPlatformMBeanServer();
        HotSpotDiagnosticMXBean mxbean = getPlatformMXBean(msc, HotSpotDiagnosticMXBean.class);
        List<VMOption> abc = mxbean.getDiagnosticOptions();

        for (VMOption vmoption:abc) {
            System.out.println("name : "+vmoption.getName()+"  value : "+vmoption.getValue());
        }

        mxbean.setVMOption("PrintGC","true");
        // System.setProperty("efg", "1234567890");

        // System.getProperties().list(System.out);

        List<VMOption> gaga = mxbean.getDiagnosticOptions();

        for (VMOption vmoption:gaga) {
            System.out.println("name= : "+vmoption.getName()+"  value= : "+vmoption.getValue());
        }
    }


    private static void addLibraryDir(String libraryPath) throws Exception {
        Field userPathsField = ClassLoader.class.getDeclaredField("usr_paths");
        userPathsField.setAccessible(true);
        String[] paths = (String[]) userPathsField.get(null);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.length; i++) {
            if (libraryPath.equals(paths[i])) {
                continue;
            }
            sb.append(paths[i]).append(';');
        }
        sb.append(libraryPath);
        System.setProperty("java.library.path", sb.toString());
        System.setProperty("efg", "1234567890");
        final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
        sysPathsField.setAccessible(true);
        sysPathsField.set(null, null);


    }


    public static void getMemoryInfo() {
        System.out.println("==========================Memory=========================");
        MemoryMXBean memoryMBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMBean.getHeapMemoryUsage();
        System.out.println("初始化 Heap: " + (usage.getInit() / 1024 / 1024) + "mb");
        System.out.println("最大Heap: " + (usage.getMax() / 1024 / 1024) + "mb");
        System.out.println("已经使用Heap: " + (usage.getUsed() / 1024 / 1024) + "mb");
        System.out.println("Heap Memory Usage: " + memoryMBean.getHeapMemoryUsage());
        System.out.println("Non-Heap Memory Usage: " + memoryMBean.getNonHeapMemoryUsage());
    }


    public static void getRunTimeInfo() {
        System.out.println("==========================Runtime=========================");
        RuntimeMXBean runtimeMBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("JVM name : " + runtimeMBean.getVmName());
        System.out.println("lib path : " + runtimeMBean.getLibraryPath());
        System.out.println("class path : " + runtimeMBean.getClassPath());
        System.out.println("getVmVersion() " + runtimeMBean.getVmVersion());
        //java options
        List<String> argList = runtimeMBean.getInputArguments();
        for (String arg : argList) {
            System.out.println("arg : " + arg);
        }
    }

    public static void getOperatingSystemInfo() {
        System.out.println("==========================OperatingSystem=========================");
        OperatingSystemMXBean osMBean = ManagementFactory.getOperatingSystemMXBean();
        //获取操作系统相关信息
        System.out.println("getName() " + osMBean.getName());
        System.out.println("getVersion() " + osMBean.getVersion());
        System.out.println("getArch() " + osMBean.getArch());
        System.out.println("getAvailableProcessors() " + osMBean.getAvailableProcessors());
    }

    public static void getThreadInfo() {
        System.out.println("==========================Thread=========================");
        //获取各个线程的各种状态，CPU 占用情况，以及整个系统中的线程状况
        ThreadMXBean threadMBean = ManagementFactory.getThreadMXBean();
        System.out.println("getThreadCount() " + threadMBean.getThreadCount());
        System.out.println("getPeakThreadCount() " + threadMBean.getPeakThreadCount());
        System.out.println("getCurrentThreadCpuTime() " + threadMBean.getCurrentThreadCpuTime());
        System.out.println("getDaemonThreadCount() " + threadMBean.getDaemonThreadCount());
        System.out.println("getCurrentThreadUserTime() " + threadMBean.getCurrentThreadUserTime());
    }

    public static void getCompilationInfo() {
        System.out.println("==========================Compilation=========================");
        CompilationMXBean compilMBean = ManagementFactory.getCompilationMXBean();
        System.out.println("getName() " + compilMBean.getName());
        System.out.println("getTotalCompilationTime() " + compilMBean.getTotalCompilationTime());
    }


    public static void getMemoryPool() {
        System.out.println("==========================MemoryPool=========================");
        //获取多个内存池的使用情况
        List<MemoryPoolMXBean> mpMBeanList = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean mpMBean : mpMBeanList) {
            System.out.println("getUsage() " + mpMBean.getUsage());
            System.out.println("getMemoryManagerNames() " + mpMBean.getMemoryManagerNames().toString());
        }
    }

    public static void getGarbageCollectorInfo() {
        System.out.println("==========================GarbageCollector=========================");
        //获取GC的次数以及花费时间之类的信息
        List<GarbageCollectorMXBean> gcMBeanList = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcMBean : gcMBeanList) {
            System.out.println("getName() " + gcMBean.getName());
            System.out.println("getMemoryPoolNames() " + Arrays.toString(gcMBean.getMemoryPoolNames()));
        }
    }

    public static void getOtherInfo() {
        System.out.println("==========================Other=========================");
        //Java 虚拟机中的内存总量,以字节为单位
        int total = (int) Runtime.getRuntime().totalMemory() / 1024 / 1024;
        System.out.println("内存总量 ：" + total + "mb");
        int free = (int) Runtime.getRuntime().freeMemory() / 1024 / 1024;
        System.out.println("空闲内存量 ： " + free + "mb");
        int max = (int) (Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("最大内存量 ： " + max + "mb");
    }


}
