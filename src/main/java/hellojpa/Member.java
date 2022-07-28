package hellojpa;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * 연관관계 편의 메소드
     * 양쪽에 연관관계 편의 메소드가 모두 있는 경우 문제를 일으킬 수 있기 때문에
     * 한쪽은 제거할 것.
     */
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
