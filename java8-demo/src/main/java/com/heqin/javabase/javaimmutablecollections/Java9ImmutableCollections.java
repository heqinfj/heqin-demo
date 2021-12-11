package com.heqin.javabase.javaimmutablecollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://javaconceptoftheday.com/java-9-immutable-collections/
 * <p>
 * Before Java 9, Collections.unmodifiableXXX() methods are used to create unmodifiable collections.
 * These methods just behave like wrapper methods which return unmodifiable view or read-only view of the original collection.
 * i.e you can’t perform modifying operations like add, remove, replace, clear etc through the references returned by these wrapper methods.
 * But, you can modify original collection if you have other references to it and those modifications will be reflected in the view returned by these methods.
 * <p>
 * For example, in the below program, unModifiableSportList is created from sportList through Collections.unmodifiableList().
 * unModifiableSportList just acts as a read-only view of the original sportList.
 * You can’t add elements to unModifiableSportList.
 * If you try to add, it will give UnsupportedOperationException.
 *
 * @Author heqin
 * @Date 2021/10/24 16:45
 */
public class Java9ImmutableCollections {
    public static void main(String[] args) {
        List<String> sportList = new ArrayList<String>();

        sportList.add("Hockey");
        sportList.add("Cricket");
        sportList.add("Tennis");

        List<String> unModifiableSportList = Collections.unmodifiableList(sportList);

        System.out.println(sportList);    //Output : [Hockey, Cricket, Tennis]

        System.out.println(unModifiableSportList);    //Output : [Hockey, Cricket, Tennis]

        //unModifiableSportList.add("Wrestling");     //It gives run-time error

        sportList.add("Kabaddi");      //It gives no error and will be reflected in unModifiableSportList

        System.out.println(sportList);    //Output : [Hockey, Cricket, Tennis, Kabaddi]

        System.out.println(unModifiableSportList);    //Output : [Hockey, Cricket, Tennis, Kabaddi]

    }
}
