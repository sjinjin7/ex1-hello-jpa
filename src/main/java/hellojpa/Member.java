package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {






    @Id
    private Long id;
    private String name;

    //JPA는 엔티티 객체에 리플렉션과 같은 작업을 해야 하기 때문에 기본 생성자가 반드시 존재 해야 한다.
    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
