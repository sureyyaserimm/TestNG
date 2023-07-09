package TestingProject_5;

import TestingProject_5.Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectFive {
    public ProjectFive() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy (css="[name='Email']")
     public WebElement mail;

    @FindBy (css="[name='Password']")
    public WebElement passwords;

    @FindBy (xpath="//button[text()='Log in']")
    public WebElement Login;

    @FindBy (xpath="(//nav[@class='mt-2']/ul/li[@class='nav-item has-treeview']/a)[3]")
    public WebElement baslik;

    @FindBy (xpath="((//nav[@class='mt-2']/ul/li/ul)[3]/li/a/p)[1]")
    public WebElement subMenu;

    @FindBy (css="[href='/Admin/Customer/Create']")
    public WebElement addNew;

    @FindBy (css="[name='Email']")
    public WebElement email;

    @FindBy (css="[name='Password']")
    public WebElement Password;

    @FindBy (css="[name='FirstName']")
    public WebElement FirstName;

    @FindBy (css="[name='LastName']")
    public WebElement LastName;

    @FindBy (css="[name='DateOfBirth']")
    public WebElement DateOfBirth;

    @FindBy (id="Gender_Female")
    public WebElement gender;

    @FindBy (css="[name='Company']")
    public WebElement Company;

    @FindBy (css="[id='IsTaxExempt']")
    public WebElement IsTaxExempt;

    @FindBy (css="[name='VendorId']")
    public WebElement VendorId;

    @FindBy (css="textarea[id='AdminComment']")
    public WebElement content;

    @FindBy (css="button[name='save']")
    public WebElement saveBtn;

    @FindBy (css="[class='alert alert-success alert-dismissable']")
    public WebElement assertMessage;

    @FindBy (css="[name='SearchEmail']")
    public WebElement SearchEmails;

    @FindBy (css="[name='SearchFirstName']")
    public WebElement SearchFirstName;

    @FindBy (css="[name='SearchLastName']")
    public WebElement SearchLastName;

    @FindBy (id="search-customers")
    public WebElement searchBtn;

    @FindBy (xpath="(//*[@class='odd']/td)[2]")
    public WebElement searchMail;

    @FindBy (xpath="(//*[@class='odd']/td)[7]/a")
    public WebElement editBtn;

    @FindBy (css="[name='FirstName']")
    public WebElement EditFirstName;


    @FindBy (css="span[id='customer-delete']")
    public WebElement delete;

    @FindBy (css="button[class='btn btn-danger float-right']")
    public WebElement confirmDelete;

    @FindBy (css="[placeholder='Search']")
    public WebElement searchInput;

    @FindBy (css="[id='user-selection']")
    public WebElement searchSub;

    @FindBy (css="h1[class='float-left']")
    public WebElement result;







}
