package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{



/**
            // 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속
            System.out.println("== BEFORE ==");
            em.persist(member);
            System.out.println("== AFTER ==");

            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

 **/
/**


            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);
 */
/**
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("=======================");
 */

/**


            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ1");

            //em.detach(member);
            em.clear();

            System.out.println("=======================");
            Member member2 = em.find(Member.class, 150L);



 */
/**
 *

            Member member = new Member();
            member.setUsername("A");

            em.persist(member);
 */

//============================================================

            /**
             Team team = new Team();
             team.setName("TeamA");
             em.persist(team);



             Member member = new Member();
             member.setUsername("member1");
             member.setTeamId(team.getId());
             em.persist(member);


             Member findMember = em.find(Member.class, member.getId());

             Long findTeamId = findMember.getTeamId();
             Team findTeam = em.find(Team.class, findTeamId);
             */

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);



            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);


            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam);



            tx.commit();
            System.out.println("=====");
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();


    }
}
