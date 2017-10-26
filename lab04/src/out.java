class Print implements Task {

        String msg;

        Print(String msg) {
                this.msg = msg;
        }

        @Override
        public void execute() {
                System.out.println(msg);
        }
}
