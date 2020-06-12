package Screen;

import Domain.NameCard;
import Service.NameCardService;

import java.util.List;
import java.util.Scanner;

public class mainScreenImpl implements mainScreen{
    private NameCardService nameCardService;
    private final boolean DEFAULT_IS_RUNNING = true;
    private boolean isRunning = DEFAULT_IS_RUNNING;

    public void setNameCardService(NameCardService nameCardService) { this.nameCardService = nameCardService; }
    private void setisRunning(boolean isRunning) { this.isRunning = isRunning; }

    private void showMenus() {
        insertCommand("--------------------\n");
        insertCommand("1. 명함 입력\n");
        insertCommand("2. 명함 검색\n");
        insertCommand("3. 종료\n");
        insertCommand("--------------------\n");
    }

    private void insertCommand(String command){
        System.out.print(command);
    }

    private int getCommand(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String getString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void run(){
        showMenus();

        while(isRunning) {
            insertCommand("메뉴를 입력하세요 : ");
            switch (getCommand()){
                case 1: insertNameCard(); break;
                case 2: searchNameCards(); break;
                case 3: setisRunning(false); break;
                default: insertCommand("잘못된 입력입니다.\n");
                         insertCommand("--------------------\n");
            }
        }
    }

    private void insertNameCard(){
        insertCommand("이름을 입력하세요 : ");
        String name = getString();

        insertCommand("전화번호를 입력하세요 : ");
        String phone = getString();

        insertCommand("회사 이름을 입력하세요 : ");
        String company = getString();

        nameCardService.addNameCard(new NameCard(name, phone, company));

        insertCommand("--------------------\n");
    }
    private void searchNameCards(){
        insertCommand("검색할 이름을 입력하세요 : ");
        String searchName = getString();

        List<NameCard> nameCardList = nameCardService.getNameCards(searchName);
        for(NameCard nameCard : nameCardList)
            insertCommand(getNameCardFormat(nameCard));
    }

    private String getNameCardFormat(NameCard nameCard) {
        return  "BussinessCard{name='" + nameCard.getName() + "', phone='" + nameCard.getPhone() +
                "', companyName='" + nameCard.getCompany() + "', createDate=" +nameCard.getDate() + "}\n";
    }
}
