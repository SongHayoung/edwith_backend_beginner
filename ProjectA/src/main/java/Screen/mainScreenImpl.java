package Screen;

import Service.NameCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service("mainScreenService")
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

        nameCardService.addNameCard(name, phone, company);

        insertCommand("--------------------\n");
    }
    private void searchNameCards(){
        insertCommand("검색할 이름을 입력하세요 : ");
        String searchName = getString();

        List<String> nameCardList = nameCardService.getNameCardsAsString(searchName);
        for(String nameCard : nameCardList)
            insertCommand(nameCard);
    }
}
