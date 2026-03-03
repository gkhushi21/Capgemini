package com.cg.bean;

    public class Book {

        private int isbn;
        private String title;
        private double price;

        // Default Constructor
        public Book() {}

        // Constructor without ISBN (for insert)
        public Book(String title, double price) {
            this.title = title;
            this.price = price;
        }

        // Constructor with all fields
        public Book(int isbn, String title, double price) {
            this.isbn = isbn;
            this.title = title;
            this.price = price;
        }

        // Getters and Setters
        public int getIsbn() {
            return isbn;
        }

        public void setIsbn(int isbn) {
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book [ISBN=" + isbn +
                    ", Title=" + title +
                    ", Price=" + price + "]";
        }
    }

