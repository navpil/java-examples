package ua.lviv.navpil;

public class TestQuery_Delete {

    public static void main(String[] args) {


        String query = " select grp.upn, em.member, eu.id from " +
                " data.exdir_entity grp join " +
                " data.exdir_members em on grp.id = em.[group] join " +
                " data.exdir_entity mbr on em.member = mbr.upn " +
                " left join data.exdir_contact eu on mbr.id = eu.id " +
                " where grp.upn = :upn ";

        System.out.println(query);
    }
}
