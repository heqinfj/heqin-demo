package com.heqin.mergedbeandefinition.spring5x.beans;

/**
 * The type Derived test bean.
 *
 * @Author heqin
 * @Date 2021 /9/13 20:53
 */
public class DerivedTestBean extends TestBean{

    private String beanName;

    private boolean initialized;

    private boolean destroyed;

    @Override
    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * Initialize.
     */
    public void initialize() {
        this.initialized = true;
    }

    /**
     * Was initialized boolean.
     *
     * @return the boolean
     */
    public boolean wasInitialized() {
        return initialized;
    }


    @Override
    public void destroy() {
        this.destroyed = true;
    }

    @Override
    public boolean wasDestroyed() {
        return destroyed;
    }

    @Override
    public String toString() {
        return "DerivedTestBean{" +
                "} " + super.toString();
    }
}
