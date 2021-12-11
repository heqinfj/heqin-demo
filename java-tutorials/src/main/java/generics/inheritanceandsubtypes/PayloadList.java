package generics.inheritanceandsubtypes;

import java.util.List;

/**
 * 定义我们自己的 list 接口 PayloadList，它将泛型类型 P 的可选值与每个元素相关联
 *
 * @Author heqin
 * @Date 2021/12/2 11:13
 */
public interface PayloadList<E, P> extends List<E> {

    void setPayload(int index, P val);

    void printContainer();
}
