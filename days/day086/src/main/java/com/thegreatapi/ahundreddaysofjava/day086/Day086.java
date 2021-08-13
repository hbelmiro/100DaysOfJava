package com.thegreatapi.ahundreddaysofjava.day086;

public class Day086 {

    public static void main(String[] args) {
        var toUpperStrategy = new ToUpperStrategy(IdentityStrategy.getInstance());
        var addPrefixStrategy = new AddPrefixStrategy(toUpperStrategy);
        var trimStrategy = new TrimStrategy(addPrefixStrategy);

        String result = trimStrategy.apply("  thegreatapi.com    ");
        System.out.println(result); // Prints: ~> THEGREATAPI.COM
    }

    @FunctionalInterface
    interface Strategy {
        String apply(String s);
    }

    abstract static class AbstractStrategy implements Strategy {
        private final Strategy delegate;

        protected AbstractStrategy(Strategy delegate) {
            this.delegate = delegate;
        }

        @Override
        public String apply(String s) {
            return delegate.apply(doApply(s));
        }

        protected abstract String doApply(String s);
    }

    static class ToUpperStrategy extends AbstractStrategy {

        ToUpperStrategy(Strategy delegate) {
            super(delegate);
        }

        @Override
        protected String doApply(String s) {
            return s.toUpperCase();
        }
    }

    static class TrimStrategy extends AbstractStrategy {

        protected TrimStrategy(Strategy delegate) {
            super(delegate);
        }

        @Override
        protected String doApply(String s) {
            return s.trim();
        }
    }

    static class AddPrefixStrategy extends AbstractStrategy {

        protected AddPrefixStrategy(Strategy delegate) {
            super(delegate);
        }

        @Override
        protected String doApply(String s) {
            return "~> " + s;
        }
    }

    static class IdentityStrategy implements Strategy {

        private static final IdentityStrategy INSTANCE = new IdentityStrategy();

        private IdentityStrategy() {
        }

        static IdentityStrategy getInstance() {
            return INSTANCE;
        }

        @Override
        public String apply(String s) {
            return s;
        }
    }
}