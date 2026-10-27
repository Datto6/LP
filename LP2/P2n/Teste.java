class Teste{
    static void main(String[] args){
        System.out.println(ValidaCPF.isCPF("123.456.789-09"));
        System.out.println(ValidaCPF.isCPF("234.567.890-92"));
        System.out.println(ValidaCPF.isCPF("345.678.901-75"));
        System.out.println(ValidaCPF.isCPF("456.789.012-49"));
        System.out.println(ValidaCPF.isCPF("567.890.123-03"));
        System.out.println(ValidaCPF.isCPF("678.901.234-69"));
        System.out.println(ValidaCPF.isCPF("789.012.345-05"));
        System.out.println(ValidaCPF.isCPF("890.123.456-42"));
        System.out.println(ValidaCPF.isCPF("901.234.567-70"));
        System.out.println(ValidaCPF.isCPF("012.345.678-90"));
    }

}