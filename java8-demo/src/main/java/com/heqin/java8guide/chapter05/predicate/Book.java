package com.heqin.java8guide.chapter05.predicate;

class Book {
    private String name;
    private String writer;

    public Book(String name, String writer) {
        this.name = name;
        this.writer = writer;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        final Book b = (Book) obj;
        if (this == b) {
            return true;
        } else {
            return (this.name.equals(b.name) && (this.writer == b.writer));
        }
    }
}
