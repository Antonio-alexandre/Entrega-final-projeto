import DAO.*;
import Model.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        HistoricoDAO historicoDAO = new HistoricoDAO();
        VeiculosDAO veiculosDAO = new VeiculosDAO();
        VagasDAO vagasDAO = new VagasDAO();
        VagaFuncionarioDAO vagaFuncionarioDAO = new VagaFuncionarioDAO();

        //Informações do Cliente
        int idc;
        String cpfc;
        String nomec;
        String emailc;

        //Informações do Funcionario
        int idf;
        String cpff;
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

        //Informações das vagas
        int idv;
        int num;
        boolean disponivel;

        boolean flag = true;
        boolean flag_switch = true;
        boolean flag_switch1 = true;
        boolean flag_switch2 = true;
        boolean flag_switch3 = true;

        int op;
        int op_switch;

        while(flag)
        {
            System.out.println("================================================");
            Thread.sleep(500);
            System.out.println("Bem-vindo ao Gestor de Estacionamento");
            Thread.sleep(500);
            System.out.println("================================================\n");
            Thread.sleep(500);

            System.out.println("Escolha a ação a ser realizada: ");
            System.out.println("1 - Área Cliente");
            System.out.println("2 - Área Funcionário");
            System.out.println("3 - Área Gerenciamento de Vagas");
            System.out.println("4 - Área Veículos");
            //System.out.println("5 - Histórico");
            System.out.println("6 - Fechar");
            System.out.println("================================================");
            System.out.println();
            op = entrada.nextInt();
            switch(op){
                case 1:
                    System.out.println("================================================\n");
                    System.out.println("Digite a operação a ser realizada: ");
                    System.out.println("1 - Cadastrar um novo cliente");
                    System.out.println("2 - Listar clientes");
                    System.out.println("3 - Registrar o veículo de um cliente");
                    System.out.println("4 - Deletar cliente");
                    System.out.println("5 - Sair");
                    System.out.println("================================================\n");
                    op_switch = entrada.nextInt();
                    entrada.nextLine();
                    while (flag_switch3){
                        switch (op_switch){
                            case 1:
                                System.out.println("Digite o cpf do cliente: ");
                                cpfc = entrada.nextLine();
                                System.out.println("Digite o nome do cliente: ");
                                nomec = entrada.nextLine();
                                System.out.println("Digite o email do cliente: ");
                                emailc = entrada.nextLine();

                                Cliente cliente = new Cliente(cpfc, nomec, emailc);
                                clienteDAO.insertCliente(cliente);
                                break;
                            case 2:
                                clienteDAO.selectCliente();
                                break;
                            case 3:
                                String novoValor = "";
                                System.out.println("Digite o CPF do cliente:");
                                String cpf_escolhido = entrada.nextLine();

                                System.out.println("Qual campo modificar? ");
                                System.out.println("1. Nome");
                                System.out.println("2. Email");
                                System.out.println("3. Veículo");

                                int op_switch_in = entrada.nextInt();
                                entrada.nextLine();

                                if(op_switch_in == 1){
                                    System.out.println("Digite o novo nome");
                                    novoValor = entrada.nextLine();
                                } else if (op_switch_in == 2) {
                                    System.out.println("Digite o novo email");
                                    novoValor = entrada.nextLine();
                                }
                        }
                    }

                    break;
                case 2:
                    while (flag_switch){
                        System.out.println("================================================\n");
                        System.out.println("Digite a operação a ser realizada: ");
                        System.out.println("1 - Cadastrar um novo funcionário");
                        System.out.println("2 - Listar funcionários");
                        System.out.println("3 - Editar informações de um funcionário");
                        System.out.println("4 - Deletar funcionário");
                        System.out.println("5 - Sair");
                        System.out.println("================================================\n");
                        op_switch = entrada.nextInt();
                        entrada.nextLine();
                        switch (op_switch){
                            case 1: // Create
                                System.out.println("Digite o cpf do funcionário: ");
                                cpff = entrada.nextLine();
                                System.out.println("Digite o nome do funcionário: ");
                                nomef = entrada.nextLine();
                                System.out.println("Digite o email do funcionário: ");
                                emailf = entrada.nextLine();

                                Funcionario funcionario = new Funcionario(cpff, nomef, emailf);
                                funcionarioDAO.insertFuncionario(funcionario);
                                break;

                            case 2: // Read
                                funcionarioDAO.selectFuncionario();
                                break;

                            case 3: // Update
                                String novoValor = "";
                                System.out.println("Digite o CPF do funcionário:");
                                String cpf_escolhido = entrada.nextLine();

                                System.out.println("Qual campo modificar? ");
                                System.out.println("1. Nome");
                                System.out.println("2. Email");

                                int op_switch_in = entrada.nextInt();
                                entrada.nextLine();

                                if(op_switch_in == 1){
                                    System.out.println("Digite o novo nome");
                                    novoValor = entrada.nextLine();
                                } else if (op_switch_in == 2) {
                                    System.out.println("Digite o novo email");
                                    novoValor = entrada.nextLine();
                                }

                                funcionarioDAO.editFuncionario(cpf_escolhido, op_switch_in, novoValor);
                                break;

                            case 4: // Delete
                                String cpf_fun = "";
                                System.out.println("Digite o cpf do funcionário a ser deletado: ");
                                cpf_fun = entrada.nextLine();

                                funcionarioDAO.deleteFuncionario(cpf_fun);
                                break;

                            case 5:
                                flag_switch = false;
                                break;
                        }

                    }
                    break;

                case 3:
                    System.out.println("================================================");
                    System.out.println("Digite a operação a ser realizada: ");
                    System.out.println("1 - Inserir informações de uma vaga.");
                    System.out.println("2 - Modificar informações de uma vaga.");
                    System.out.println("3 - Listar vagas");
                    System.out.println("4 - Sair");
                    System.out.println("================================================\n");
                    Thread.sleep(500);
                    op_switch = entrada.nextInt();

                    while (flag_switch1){
                        switch(op_switch){
                            case 1:
                                String funcionario_vaga = "";
                                int num_funcionarios;
                                System.out.println("Digite o número da vaga: ");
                                num = entrada.nextInt();
                                disponivel = true;
                                System.out.println("Digite quantos funcionários serão responsáveis pela vaga");
                                num_funcionarios = entrada.nextInt();
                                entrada.nextLine();
                                Vagas vaga = new Vagas(num, disponivel);
                                vagasDAO.insertVaga(vaga);

                                for (int i = 0; i< num_funcionarios; i++){
                                    System.out.println("Digite o cpf dos funcionário " + i + " responsável pela vaga: ");
                                    funcionario_vaga = entrada.nextLine();
                                    vagaFuncionario vaga_funcionario = new vagaFuncionario(funcionario_vaga, num);
                                    vagaFuncionarioDAO.insertVagaFuncionario(num,funcionario_vaga);
                                }
                                break;
                            case 2:
                                System.out.println("Digite o número da vaga a ser modificada: ");
                                break;
                            case 3:
                                vagasDAO.selectVaga();
                                break;
                            case 4:
                                flag_switch1 = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("================================================\n");
                    System.out.println("Digite a operação a ser realizada: ");
                    System.out.println("1 - Cadastrar um novo veículo");
                    System.out.println("2 - Listar veículos");
                    System.out.println("3 - Deletar veículo");
                    System.out.println("4 - Sair");
                    System.out.println("================================================\n");
                    op_switch = entrada.nextInt();
                    while(flag_switch2){
                        switch (op_switch){
                            case 1:
                                System.out.println("Digite a placa do veículo: ");
                                placa = entrada.nextLine();
                                System.out.println("Digite a cor do veículo: ");
                                cor = entrada.nextLine();
                                System.out.println("Digite o modelo do veículo: ");
                                modelo = entrada.nextLine();

                                Veiculos veiculo = new Veiculos(placa, cor, modelo);
                                veiculosDAO.insertVeiculos(veiculo);
                                break;
                            case 2:
                                veiculosDAO.selectVeiculo();
                                break;
                            case 3:
                                System.out.println("Digite a placa do veículo a ser removido: ");
                                placa = entrada.nextLine();
                                veiculosDAO.deleteVeiculo(placa);
                                break;
                        }
                    }
                    break;
                case 5:
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Digite um valor válido!!!");
            }
        }
    }


}