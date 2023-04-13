package ua.lviv.navpil.exceptions;

import javax.xml.stream.XMLInputFactory;

public class PrintStackTrace {

    private static String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?><s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Header><h:ServerVersionInfo MajorVersion=\"14\" MinorVersion=\"2\" MajorBuildNumber=\"309\n" +
            "\" MinorBuildNumber=\"3\" Version=\"Exchange2010_SP2\" xmlns:h=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns\n" +
            ":xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"/></s:Header><s:Body><m:GetFolderResponse xmlns:m=\"http://schemas.microsoft.com/exchange/service\n" +
            "s/2006/messages\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\"><m:ResponseMessages><m:GetFolderResponseMessage ResponseClass=\"Success\"><m:ResponseCode>NoError</m:Respo\n" +
            "nseCode><m:Folders><t:CalendarFolder><t:FolderId Id=\"AAMkADExNjY4ZWRmLWIwN2YtNDAxMS05ZjEzLTg3YTRiMjQ0ZGY3ZQAuAAAAAADU0n/e4OgzQYvxnEFT1sxPAQA1LVqe3bVEQ6g4HVLTxYapAFiIzwa6AAA=\" ChangeKey=\"AgA\n" +
            "AABYAAACUAPkRiik5TYV1B0n4GmWXAAAAAj0P\"/><t:ParentFolderId Id=\"AAMkADExNjY4ZWRmLWIwN2YtNDAxMS05ZjEzLTg3YTRiMjQ0ZGY3ZQAuAAAAAADU0n/e4OgzQYvxnEFT1sxPAQA1LVqe3bVEQ6g4HVLTxYapAFiI0lHWAAA=\" Chang\n" +
            "eKey=\"AQAAAA==\"/><t:FolderClass>IPF.Appointment</t:FolderClass><t:DisplayName>Calendar</t:DisplayName><t:TotalCount>2</t:TotalCount><t:ChildFolderCount>0</t:ChildFolderCount><t:EffectiveRig\n" +
            "hts><t:CreateAssociated>true</t:CreateAssociated><t:CreateContents>true</t:CreateContents><t:CreateHierarchy>true</t:CreateHierarchy><t:Delete>true</t:Delete><t:Modify>true</t:Modify><t:Rea\n" +
            "d>true</t:Read><t:ViewPrivateItems>true</t:ViewPrivateItems></t:EffectiveRights><t:PermissionSet><t:CalendarPermissions><t:CalendarPermission><t:UserId><t:DistinguishedUser>Default</t:Disti\n" +
            "nguishedUser></t:UserId><t:CanCreateItems>false</t:CanCreateItems><t:CanCreateSubFolders>false</t:CanCreateSubFolders><t:IsFolderOwner>false</t:IsFolderOwner><t:IsFolderVisible>false</t:IsF\n" +
            "olderVisible><t:IsFolderContact>false</t:IsFolderContact><t:EditItems>None</t:EditItems><t:DeleteItems>None</t:DeleteItems><t:ReadItems>TimeOnly</t:ReadItems><t:CalendarPermissionLevel>Free\n" +
            "BusyTimeOnly</t:CalendarPermissionLevel></t:CalendarPermission><t:CalendarPermission><t:UserId><t:DistinguishedUser>Anonymous</t:DistinguishedUser></t:UserId><t:CanCreateItems>false</t:CanC\n" +
            "reateItems><t:CanCreateSubFolders>false</t:CanCreateSubFolders><t:IsFolderOwner>false</t:IsFolderOwner><t:IsFolderVisible>false</t:IsFolderVisible><t:IsFolderContact>false</t:IsFolderContac\n" +
            "t><t:EditItems>None</t:EditItems><t:DeleteItems>None</t:DeleteItems><t:ReadItems>None</t:ReadItems><t:CalendarPermissionLevel>None</t:CalendarPermissionLevel></t:CalendarPermission></t:Cale\n" +
            "ndarPermissions></t:PermissionSet></t:CalendarFolder></m:Folders></m:GetFolderResponseMessage></m:ResponseMessages></m:GetFolderResponse></s:Body></s:Envelope>";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        Class c = Class.forName("com.sun.xml.internal.stream.XMLInputFactoryImpl");
        Object o = c.newInstance();
        XMLInputFactory inputFactory = (XMLInputFactory) o;
//        return inputFactory.createXMLEventReader(stream);



        try {
            doSmth();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void doSmth() {
        throw new NullPointerException();
    }
}
