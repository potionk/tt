import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChampionTest {

    private List<Champion> champions = new ArrayList<Champion>();
    private List<String> championNames;

    @Before
    public void setUp(){
        Champion topChamp = new Champion("다리우스","탑");
        Champion jungleChamp = new Champion("리신","정글");
        Champion midChamp = new Champion("르블랑","미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        champions.add(topChamp);
        champions.add(jungleChamp);
        champions.add(midChamp);
        champions.add(adcChamp);
        champions.add(supportChamp);
    }

    @Test
    public void givenCollectionWhenEmptyCorrect(){
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void givenStringWhenNotNullIsCorrect(){
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    @Test
    public void givenStringWhenNullIsCorrect(){
        String lck = null;
        assertThat(lck, nullValue());
    }

    @Test
    public void givenStringWhenMeetsAnyOfGivenConditionsThenCorrect() {
        String sampleString = "Player Focus";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString, anyOf(startsWith(startString), containsString(endString)));
    }

    @Test
    public void givenStringWhenMeetsAllOfGivenConditionsThenCorrect() {
        String sampleString = "Player Focus";
        String startString = "Player";
        String endString = "Focus";
        assertThat(sampleString, anyOf(startsWith(startString), containsString(endString)));
    }

    @Test
    public void givenADoubleWhenCloseToThenCorrect() {
        assertThat(3.14, closeTo(3, 0.2));
    }

    @Test
    public void shouldNotErrorGetReference(){
        assertThat(champions.get(2), anything());
    }

    @Test
    public void shouldChampionCountFive() {
        assertTrue(champions.size() == 5);
        assertThat(champions.size(), is(5));
        assertThat(champions, hasSize(5));
    }

    @Test
    public void shouldSupportChampIsTaric(){
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));
    }

    @Test
    public void shouldHasPropertyPosition(){
        assertThat(champions.get(0), hasProperty("position"));
        assertThat(champions.get(0), hasProperty("position", equalTo("탑")));
    }

    @Test
    public void shouldHaveSomeChampName(){
        championNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames.get(0), hasToString("루시안"));
    }

    @Test
    public void shouldHaveSamePropertyAndValue(){
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
    }

    @Test
    public void shouldTopChampionIsDarius(){
        Optional<Champion> filterdChampion = champions.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }
}