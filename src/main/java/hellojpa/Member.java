package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1
)
public class Member extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    /**
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    //@ManyToMany
    //@JoinTable(name = "MEMBER_PRODUCT")
    //private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();
    **/


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

    /*연관관계 편의 메서드
    둘중 하나를 정해서 한쪽에 편의 메서드를 만들어 주면 됨*/
    public void changeTeam(Team team) {
        this.team = team;

        team.getMembers().add(this);
    }

}
