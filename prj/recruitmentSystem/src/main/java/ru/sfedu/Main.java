package ru.sfedu;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import ru.sfedu.api.DataProviderCsv;
import ru.sfedu.api.DataProviderH2;
import ru.sfedu.api.DataProviderXml;
import ru.sfedu.api.IDataProvider;
import ru.sfedu.model.TypePerson;
import ru.sfedu.util.ConfigurationUtil;
import ru.sfedu.util.LogicService;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class.getName());
    
    public static void main(String[] args){
        log.info("main [1]: start");
        
        String configPath = System.getProperty(Constants.CLI_CONFIG);
        if(configPath != null){
            log.info("main [2]: setting config path, path = {}", configPath);
            ConfigurationUtil.setConfigPath(configPath);
        }
        
        String log4Path = System.getProperty(Constants.CLI_LOG4J);
        if(log4Path != null){
            log.info("main [3]: setting log4j path, path = {}", log4Path);
            try{
                File file = new File(log4Path);
                LoggerContext context = (LoggerContext) LogManager.getContext(false);
                context.setConfigLocation(file.toURI());
            } catch(Exception ex){
                log.error("main [4]: такого файла нет или он неправильный, error = {}", ex.getMessage());
            }
        }
        
        IDataProvider dataProvider;
        try{
            switch(args[0]){
                case Constants.CLI_CSV:{
                    dataProvider = new DataProviderCsv();
                    break;
                }
                case Constants.CLI_H2:{
                    dataProvider = new DataProviderH2();
                    break;
                }
                default:{
                    dataProvider = new DataProviderXml();
                    break;
                }
            }
            
            String command = args[1];
        
            LogicService service = new LogicService(dataProvider);

            if(command.equals(Constants.CLI_REGISTRATION_CLIENTALL)){
                log.info("main [5]: registration client with all fields");
                try{
                    String name = args[2];
                    String surname = args[3];
                    int age = Integer.parseInt(args[4]);
                    String password = args[5];
                    String address = args[6];
                    String middleName = args[7];
                    String birthday = args[8];
                    String phone = args[9];
                    String email = args[10];

                    try{
                        service.clientRegistration(name, surname, middleName, age, birthday, phone, email, password, address);
                    } catch(Exception ex){
                        log.error("main [6]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [7]: неправильные данные, error = {}", ex.getMessage());
                }
            }

            if(command.equals(Constants.CLI_REGISTRATION_CLIENT)){
                log.info("main [8]: registration client only required fields");
                try{
                    String name = args[2];
                    String surname = args[3];
                    int age = Integer.parseInt(args[4]);
                    String password = args[5];
                    String address = args[6];

                    try{
                        service.clientRegistration(name, surname, null, age, null, null, null, password, address);
                    } catch(Exception ex){
                        log.error("main [9]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [10]: неправильные данные, error = {}", ex.getMessage());
                }
            }

            if(command.equals(Constants.CLI_REGISTRATION_RESUMEALL)){
                log.info("main [11]: registration resume with all fields");
                try{
                    int idClient = Integer.parseInt(args[2]);
                    String profession = args[3];
                    String city = args[4];
                    String skills = args[5];
                    String education = args[6];
                    String experience = args[7];
                    boolean sex = Boolean.parseBoolean(args[8]);
                    boolean workPermit = Boolean.parseBoolean(args[9]);
                    String citizenship = args[10];

                    try{
                        service.resumeRegistration(idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
                    } catch(Exception ex){
                        log.error("main [12]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [13]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_REGISTRATION_RESUME)){
                log.info("main [14]: registration resume only required fields");
                try{
                    int idClient = Integer.parseInt(args[2]);
                    String profession = args[3];
                    String city = args[4];
                    boolean sex = Boolean.parseBoolean(args[5]);
                    boolean workPermit = Boolean.parseBoolean(args[6]);
                    
                    try{
                        service.resumeRegistration(idClient, profession, city, null, null, null, sex, workPermit, null);
                    } catch(Exception ex){
                        log.error("main [15]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [16]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_REGISTRATION_COMPANY)){
                log.info("main [17]: registration company");
                try{
                    String title = args[2];
                    String description = args[3];
                    
                    try{
                        service.companyRegistration(title, description);
                    } catch(Exception ex){
                        log.error("main [18]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [19]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_REGISTRATION_VACANCYALL)){
                log.info("main [20]: registration vacancy with all fields");
                try{
                    int idCompany = Integer.parseInt(args[2]);
                    String title = args[3];
                    String specialization = args[4];
                    boolean online = Boolean.parseBoolean(args[5]);
                    String skills = args[6];
                    int salary = Integer.parseInt(args[7]);
                    String city = args[8];
                    String address = args[9];
                    String experience = args[10];
                    
                    try{
                        service.vacancyRegistration(idCompany, title, specialization, online, skills, salary, city, address, experience);
                    } catch(Exception ex){
                        log.error("main [21]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [22]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_REGISTRATION_VACANCY)){
                log.info("main [23]: registration vacancy only required fields");
                try{
                    int idCompany = Integer.parseInt(args[2]);
                    String title = args[3];
                    boolean online = Boolean.parseBoolean(args[4]);
                    int salary = Integer.parseInt(args[5]);
                    
                    try{
                        service.vacancyRegistration(idCompany, title, null, online, null, salary, null, null, null);
                    } catch(Exception ex){
                        log.error("main [24]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [25]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_HIRE)){
                log.info("main [26]: hiring");
                try{
                    int idResume = Integer.parseInt(args[2]);
                    int idVacancy = Integer.parseInt(args[3]);
                                        
                    try{
                        service.hireEmployee(idResume, idVacancy);
                    } catch(Exception ex){
                        log.error("main [27]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [28]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_GIVE_ASSESSMENT)){
                log.info("main [29]: hiring");
                try{
                    int idEmployee = Integer.parseInt(args[2]);
                    int idCompany = Integer.parseInt(args[3]);
                    int quality = Integer.parseInt(args[4]);
                    String description = args[5];
                                        
                    try{
                        service.giveAssessment(idEmployee, idCompany, quality, description);
                    } catch(Exception ex){
                        log.error("main [30]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [31]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_CALCULATE_ASSESSMENT)){
                log.info("main [32]: calculate assessment");
                try{
                    int idCompany = Integer.parseInt(args[2]);
                                        
                    try{
                        service.calculateAssessment(idCompany);
                    } catch(Exception ex){
                        log.error("main [33]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [34]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_CHANGE_CLIENT)){
                log.info("main [35]: change client");
                try{
                    int id = Integer.parseInt(args[2]);
                    String name = args[3];
                    String surname = args[4];
                    int age = Integer.parseInt(args[5]);
                    String password = args[6];
                    String address = args[7];
                    String middleName = args[8];
                    String birthday = args[9];
                    String phone = args[10];
                    String email = args[11];

                    try{
                        service.clientChange(id, name, surname, middleName, age, birthday, phone, email, password, address);
                    } catch(Exception ex){
                        log.error("main [36]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [37]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_CHANGE_RESUME)){
                log.info("main [38]: change resume");
                try{
                    int id = Integer.parseInt(args[2]);
                    int idClient = Integer.parseInt(args[3]);
                    String profession = args[4];
                    String city = args[5];
                    String skills = args[6];
                    String education = args[7];
                    String experience = args[8];
                    boolean sex = Boolean.parseBoolean(args[9]);
                    boolean workPermit = Boolean.parseBoolean(args[10]);
                    String citizenship = args[11];

                    try{
                        service.resumeChange(id, idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
                    } catch(Exception ex){
                        log.error("main [39]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [40]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_CHANGE_COMPANY)){
                log.info("main [41]: change company");
                try{
                    int id = Integer.parseInt(args[2]);
                    String title = args[3];
                    String description = args[4];
                    
                    try{
                        service.companyChange(id, title, description);
                    } catch(Exception ex){
                        log.error("main [42]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [43]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_CHANGE_VACANCY)){
                log.info("main [44]: change vacancy");
                try{
                    int id = Integer.parseInt(args[2]);
                    int idCompany = Integer.parseInt(args[3]);
                    String title = args[4];
                    String specialization = args[5];
                    boolean online = Boolean.parseBoolean(args[6]);
                    String skills = args[7];
                    int salary = Integer.parseInt(args[8]);
                    String city = args[9];
                    String address = args[10];
                    String experience = args[11];
                    
                    try{
                        service.vacancyChange(id, idCompany, title, specialization, online, skills, salary, city, address, experience);
                    } catch(Exception ex){
                        log.error("main [45]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [46]: неправильные данные, error = {}", ex.getMessage());
                }
            }
            
            if(command.equals(Constants.CLI_DELETE_RESUME) || command.equals(Constants.CLI_DELETE_CLIENT) || command.equals(Constants.CLI_DELETE_COMPANY) || command.equals(Constants.CLI_DELETE_VACANCY) || command.equals(Constants.CLI_DELETE_SEPARATE_QUAL) || command.equals(Constants.CLI_DELETE_RESUME)){
                log.info("main [47]: delete");
                try{
                    int id = Integer.parseInt(args[2]);
                    
                    try{
                        switch(command){
                            case Constants.CLI_DELETE_RESUME -> service.deleteResume(id);
                            case Constants.CLI_DELETE_COMPANY -> service.deleteCompany(id);
                            case Constants.CLI_DELETE_CLIENT -> service.deletePerson(id, TypePerson.ClientType);
                            case Constants.CLI_DELETE_SEPARATE_QUAL -> service.deleteSeparateQual(id);
                            case Constants.CLI_DELETE_VACANCY -> service.deleteVacancy(id);
                        }
                    } catch(Exception ex){
                        log.error("main [48]: error = {}", ex.getMessage());
                    }

                } catch(Exception ex){
                    log.error("main [49]: неправильные данные, error = {}", ex.getMessage());
                }
            }
        } catch(Exception ex){
            log.error("main [N]: введите команду");
        }
        
    }

}
