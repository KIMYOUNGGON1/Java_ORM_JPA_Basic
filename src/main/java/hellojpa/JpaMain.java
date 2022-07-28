package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //저장
            Team team = new Team();
            team.setName("TeamA");
//            team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
//            member.changeTeam(team); //**
            em.persist(member);

            team.addMember(member); //**

            /**
             * 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정해야 한다. [//**]
             * 연관관계 편의 메소드를 Member.class에 설정해 줌으로서 아래의 코드 생략 가능
             */
//            team.getMembers().add(member); //**

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("=====================");
            for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("=====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
