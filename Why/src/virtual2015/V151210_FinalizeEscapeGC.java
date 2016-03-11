package virtual2015;

/**
 * Created by emi on 2015/12/10.
 * 一次对象自我拯救的演示，此代码演示了两点：
 * 1.对象可以再被GC时自我拯救；
 * 2：这种自救机会只有一次，因为一个对象的finalize（）方法最多只能被系统自动调用一次，（可关联参考ReferenceTest查看4种引用）
 */
public class V151210_FinalizeEscapeGC {

    public static V151210_FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println(" yes, I am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(" finalize method executed!");
        V151210_FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new V151210_FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize()优先级很低，所以等0.5s
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" no, I am dead :(");
        }

        //这段代码与上面的完全相同，但却自救失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize()优先级很低，所以等0.5s
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" no, I am dead :(");
        }

    }
}
/**
 * 即使可达性分析算法中的不可达对象（没有与GC Roots相连接的引用链），也不一定“非死不可”，要真正宣告一个对象死亡，至少要经历两次标记：
 * 当分析后是不可达对象，将被第一次标记并且执行一次筛选（是否有必要执行finalize())。没必要情况：对象没有覆盖finalize(),或已经执行过finalize().
 * 党有必要执行时：这个对象会被放置在一个叫F-Queue的队列中，稍后由一个优先级低的Finalizer线程去执行它（不保证一定执行）。
 * 稍后GC对F-Queue对象做第二次标记，如果对象在finalize()中成功拯救自己（重新与引用链上任何一个对象建立关联），那么在第二次标记时，它将被移除“即将回收”的集合；
 */


