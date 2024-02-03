# Options

recruitment system based on csv, xml and h2 data sources.

sudo systemctl start mongod - запуск монги

## общий вид команд
java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> <команда> <data>
 


### регистрация клиента
java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -client [name] [surname] [age] [password] [address] [middleName] [birthday] [phone] [email]
 
#### пример
 java -jar recruitmentSystem.jar XML -client mike seleznev 33 pippop zorge Mihail 12-12-2003 89994095446 my.rs@lab.com
 

 
### регистрация резюме
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -resume [IdClient] [profession] [city] [skills] [education] [experience] [sex] [workPermit] [citizenship]
 
#### пример
  java -jar recruitmentSystem.jar XML -resume 1 developer ANAPA 'SOAP, API' sfedu '1-3 years' true true Russian
 
 *Примечание
  - перед созданием резюме, нужно создать клиента.
  

 
### регистрация компании
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -company [title] [description]
 
#### пример
   java -jar recruitmentSystem.jar XML -company ArenaData 'Company works with data bases'
  
---
 
### регистрация вакансии
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -vacancy [idCompany] [title] [specialization] [online] [skills] [salary] [city] [address] [experience]
 
#### пример
 java -jar recruitmentSystem.jar XML -vacancy 1 Java 'Back end' true 'Soap, api, spring' 150000 rostov center '2-3 years'

#### Примечание
  - перед регистрацией вакансии , нужно зарегистрировать компанию.
  
---
 
### нанимаем работаника через резюме и вакансию
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -hire [idResume] [idVacancy] [test]
 
 параметр test - позволяет отправить письмо еще и с приглашением на тест
 
#### пример
 java -jar recruitmentSystem.jar XML -hire 1 1 false
 
 java -jar recruitmentSystem.jar XML -hire 1 1 true

#### Примечание
  - перед тем, как нанять сотрудника, нужно зарегистрировать резюме и вакансию.
  
---
 
### даем оценку компании
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -ga [idEmployee] [idCompany] [quality] [description]
 
#### пример
 java -jar recruitmentSystem.jar XML -ga 1 1 7 'not perfect but good'

#### Примечание
  - перед тем, как давать оценку, нужно зарегистрировать компанию и нанять сотрудника.
  - [quality] - значение 0-10
  
---
 
### анализ оценок компании
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -ca [idCompany] [others]
 
 параметр others - позволяет выбрать: генерировать результат с местом среди остальных компаний, или только среднее всех оценок данной компании
 
#### пример
 java -jar recruitmentSystem.jar XML -ca 1 false
  
 java -jar recruitmentSystem.jar XML -ca 1 true
  
#### Примечание
  - результат - csv файл
 
---

### изменение данных клиента
java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -clientChange [id] [name] [surname] [age] [password] [address] [middleName] [birthday] [phone] [email]
 
#### пример
 java -jar recruitmentSystem.jar XML -clientChange 1 Liza Gonchar 20 pippop zorge Mihail 12-12-2003 89994095446 my.rs@lab.com
 
---
 
### изменение данных резюме
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -resumeChange [id] [IdClient] [profession] [city] [skills] [education] [experience] [sex] [workPermit] [citizenship]
 
#### пример
  java -jar recruitmentSystem.jar XML -resumeChange 1 1 MANAGER ANAPA 'SOAP, API' sfedu '1-3 years' false true Russian
 
---
 
### изменение данных компании
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -companyChange [id] [title] [description]
 
#### пример
   java -jar recruitmentSystem.jar XML -companyChange 1 ASSENTURE 'Company works with child'
  
---
 
### изменение данных вакансии
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -vacancyChange [id]  [idCompany] [title] [specialization] [online] [skills] [salary] [city] [address] [experience]
 
#### пример
 java -jar recruitmentSystem.jar XML -vacancyChange 1 1 уборщица 'метла' true 'ответственность' 35000 krasnodat center 'без опыта'

---
 
### удаление резюме
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -resumeD [id] 
 
#### пример
 java -jar recruitmentSystem.jar XML -resumeD 1
 
---
 
### удаление клиента
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -clientD [id] 
 
#### пример
 java -jar recruitmentSystem.jar XML -clientD 1
  
#### Примечание
  - все резюме этого клиента также удалятся. CASCADE
  
---
 
### удаление вакансии
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -vacancyD [id] 
 
#### пример
 java -jar recruitmentSystem.jar XML -vacancyD 1

---
 
### удаление оценки
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -spD [id] 
 
#### пример
 java -jar recruitmentSystem.jar XML -spD 1  
 
---
 
### удаление компании
 java -jar -Dconfig=<путь до конфигурационного файла> -Dlog4j=<путь до файла конфигурации логов>
 recruitmentSystem.jar <тип провайдера> -companyD [id] 
 
#### пример
 java -jar recruitmentSystem.jar XML -companyD 1  
  
#### Примечание
  - все работники, вакансии и оценки этой компании также удалятся. CASCADE
  
---
  
# -- HELP --

| Имя диаграммы           |      Тип диаграммы      |
|-------------------------|:-----------------------:|
| Диаграмма активностей   |  [activity](#activity)  |
| Диаграмма классов       |     [class](#class)     |
| Диаграмма компонентов   | [component](#component) |
| Диаграмма использования |   [useCase](#useCase)   |

# Диаграммы
## Диаграмма классов
<a name="class">![Image alt](https://github.com/Myrs-19/recruitmentSystem/blob/main/docs/DiagramClasses.png)</a>

[Uml код диаграммы](../main/docs/DiagramClasses.xmi)

## Диаграмма активностей
<a name="activity">![Image alt](https://github.com/Myrs-19/recruitmentSystem/blob/main/docs/DiagramActivity.png)</a>

[Uml код диаграммы](../main/docs/DiagramUseCases.xmi)

## Диаграмма использования
<a name="useCase">![Image alt](https://github.com/Myrs-19/recruitmentSystem/blob/main/docs/DiagramUseCases.png)</a>

[Uml код диаграммы](../main/docs/DiagramUseCases.xmi)

## Диаграмма компонентов
<a name="component">![Image alt](https://github.com/Myrs-19/recruitmentSystem/blob/main/docs/DiagrammComponents.png)</a>

[Uml код диаграммы](../main/docs/DiagramUseCases.xmi)
