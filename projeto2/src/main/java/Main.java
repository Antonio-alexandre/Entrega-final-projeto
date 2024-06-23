import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.HistoricoDAO;
import DAO.VeiculosDAO;
import Model.Cliente;
import Model.Funcionario;
import Model.Historico;
import Model.Veiculos;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        HistoricoDAO historicoDAO = new HistoricoDAO();
        VeiculosDAO veiculosDAO = new VeiculosDAO();

        //Informações do Cliente
        int idc;
        long cpfc;
        String nomec;
        String emailc;

        //Informações do Funcionario
        int idf;
        long cpff;
        String nomef;
        String emailf;

        //Informações do veículo
        int idve;
        String placa;
        String cor;
        String modelo;

        //Informações do histórico
        int idh;
        String horariosaida;
        String horarioentrada;

        boolean flag = true;

        int op;

        while(flag)
        {
            System.out.println("================================================");
            System.out.println("Escolha a ação a ser realizada: ");
            System.out.println("1 - Adicionar um Cliente no banco de dados");
            System.out.println("2 - Deletar um cliente do banco de dados");
            System.out.println("3 - Mostrar todos os clientes registrados: ");
            System.out.println("4 - Adicionar um funcionário no banco de dados");
            System.out.println("5 - Deletar um funcionário do banco de dados");
            System.out.println("6 - Mostrar todos os funcionários registrados");
            System.out.println("7 - Adicionar um veículo no banco de dados");
            System.out.println("8 - Deletar um veiculo do banco de dados");
            System.out.println("9 - Mostrar todos os veículos registrados");
            System.out.println("10 - Registrar o historico no banco de dados");
            System.out.println("11 - Deletar o registro do historico do banco de dados");
            System.out.println("12 - Mostrar todos os registros de histórico registrados");
            System.out.println("0 - Fechar o menu");
            System.out.println("================================================");
            System.out.println();
            op = entrada.nextInt();
            switch(op){
                case 1:
                    System.out.println("Digite o id do cliente: ");
                    idc = entrada.nextInt();
                    System.out.println("Digite o cpf do cliente: ");
                    cpfc = entrada.nextLong();
                    System.out.println("Digite o nome do cliente: ");
                    nomec = entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("Digite o email do cliente: ");
                    emailc = entrada.nextLine();

                    Cliente cliente = new Cliente(idc, cpfc, nomec, emailc);
                    clienteDAO.insertCliente(cliente);
                    break;
                case 2:
                    System.out.println("Digite o id do cliente a ser deletado: ");
                    idc = entrada.nextInt();
                    clienteDAO.deleteCliente(idc);
                    break;
                case 3:
                    clienteDAO.selectCliente();
                    break;
                case 4:
                    System.out.println("Digite o id do funcionário: ");
                    idf = entrada.nextInt();
                    System.out.println("Digite o cpf do funcionário: ");
                    cpff = entrada.nextLong();
                    System.out.println("Digite o nome do funcionário: ");
                    nomef = entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("Digite o email do funcionário: ");
                    emailf = entrada.nextLine();

                    Funcionario funcionario = new Funcionario(idf, cpff, nomef, emailf);
                    funcionarioDAO.insertFuncionario(funcionario);
                    break;
                case 5:
                    System.out.println("Digite o id do funcionário a ser deletado: ");
                    idf = entrada.nextInt();
                    funcionarioDAO.deleteFuncionario(idf);
                    break;
                case 6:
                    funcionarioDAO.selectFuncionario();
                    break;
                case 7:
                    System.out.println("Digite o id do veículo: ");
                    idve = entrada.nextInt();
                    System.out.println("Digite a placa do veículo: ");
                    placa = entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("Digite a cor do veículo: ");
                    cor = entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("Digite o modelo do veículo: ");
                    modelo = entrada.nextLine();

                    Veiculos veiculo = new Veiculos(idve, placa, cor, modelo);
                    veiculosDAO.insertVeiculos(veiculo);
                    break;
                case 8:
                    System.out.println("Digite o id do veículo a ser deletado: ");
                    idve = entrada.nextInt();
                    veiculosDAO.deleteVeiculo(idve);
                    break;
                case 9:
                    veiculosDAO.selectVeiculo();
                case 10:
                    System.out.println("Digite o id do registro de histórico: ");
                    idh = entrada.nextInt();
                    System.out.println("Digite o horário de saída:");
                    horariosaida = entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("Digite o horário de entrada: ");
                    horarioentrada = entrada.nextLine();

                    Historico historico = new Historico(idh, horariosaida, horarioentrada);
                    historicoDAO.insertHistorico(historico);
                    break;
                case 11:
                    System.out.println("Digite o id do registro de histórico a ser deletado: ");
                    idh = entrada.nextInt();
                    historicoDAO.deleteHistorico(idh);
                    break;
                case 12:
                    historicoDAO.selectHistorico();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Digite um valor válido!!!");
            }
        }
    }
}