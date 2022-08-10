package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

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



/**
            Team team = new Team();
            team.setName("TeamA");
            //team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

            //team.getMembers().add(member);

            System.out.println("team.getMembers() = " + team.getMembers());
            for (Member teamMember : team.getMembers()) {
                System.out.println("teamMember = " + teamMember);
            }

            System.out.println("==========");



            em.flush();
            em.clear();
**/
/*==============*/
            /**
            Movie movie = new Movie();
            movie.setDirector("A");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);
            **/
            /*==============*/

            /*mappedSuper*/

            /**
            Member member = new Member();
            member.setUsername("user1");
            member.setCreatedBy("kim");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();
            **/

            /*==============*/
            /**

            Member member1 = new Member();
            member1.setUsername("member1");

            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");

            em.persist(member2);


            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember.getClass() = " + refMember.getClass()); //Proxy

            Hibernate.initialize(refMember);

             **/

            /*======*/

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();
            Member m = em.find(Member.class, member1.getId());

            System.out.println("m = " + m.getTeam().getClass());

            System.out.println("=========");
            m.getTeam().getName();
            System.out.println("=========");



            tx.commit();
            System.out.println("=====");
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();


    }
}
