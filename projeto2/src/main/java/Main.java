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
        long cpfc;
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

        int op;
        int op_switch;

        while(flag)
        {
            System.out.println("================================================");
            Thread.sleep(1000);
            System.out.println("Bem-vindo ao Gestor de Estacionamento");
            Thread.sleep(1000);
            System.out.println("================================================\n");
            Thread.sleep(1000);

            System.out.println("Escolha a ação a ser realizada: ");
            System.out.println("1 - Área Cliente");
            System.out.println("2 - Área Funcionário");
            System.out.println("3 - Área Gerenciamento de Vagas");
            System.out.println("4 - Área Veículos");
            System.out.println("5 - Histórico");
            System.out.println("================================================");
            System.out.println();
            op = entrada.nextInt();
            switch(op){
                case 1:
                    System.out.println("Todos os clientes cadastrados: ");

                    break;
                case 2:
                    while (flag_switch){
                        System.out.println("Escolha uma operação:");
                        Thread.sleep(1000);
                        System.out.println("1. Cadastro");
                        System.out.println("2. Listagem");
                        System.out.println("3. Editar");
                        System.out.println("4. Deletar Funcionário");
                        System.out.println("5. Sair");
                        op_switch = entrada.nextInt();
                        entrada.nextLine();
                        switch (op_switch){
                            case 1: // Create
                                System.out.println("Digite o cpf do funcionário: ");
                                entrada.nextLine();
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
                                System.out.println("Digite o cpf");
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
                    System.out.println("================================================\n");
                    op_switch = entrada.nextInt();

                    switch(op_switch){
                        case 1:
                            String funcionario_vaga = "";
                            System.out.println("Digite o número da vaga: ");
                            num = entrada.nextInt();
                            disponivel = true;
                            System.out.println("Digite o cpf dos funcionários responsável pela vaga: ");
                            funcionario_vaga = entrada.nextLine();
                            Vagas vaga = new Vagas(num, disponivel);
                            vagaFuncionario vaga_funcionario = new vagaFuncionario(funcionario_vaga, num);
                            vagasDAO.insertVaga(vaga);
                            vagaFuncionarioDAO.insertVagaFuncionario(num,funcionario_vaga);
                            break;
                        case 2:
                            System.out.println("Digite o número da vaga a ser modificada: ");
                            break;
                        case 3:
                            vagasDAO.selectVaga();
                            break;
                    }
                    break;
                case 4:

                    break;
                case 5:
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