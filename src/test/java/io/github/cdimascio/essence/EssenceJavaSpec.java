package github.cdimascio.essence;

import io.github.cdimascio.essence.Essence;
import io.github.cdimascio.essence.EssenceResult;
import io.github.cdimascio.essence.Language;
import org.junit.Test;

import static io.github.cdimascio.essence.FixturesKt.readFileFull;

public class EssenceJavaSpec {

    @Test
    public void parse() {
        String html = readFileFull("./fixtures/test_bbc_japenese.html");
        EssenceResult data = Essence.extract(html, Language.ja);
        System.err.println(data);


    }

    private String cleanTestingTest(String newText, String originalText) {
        return newText.
            replace("\n\n", " ").
            replace("\\ \\", " ")
            .substring(0, Math.min(newText.length(), originalText.length()));
    }

    private String cleanOrigText(String text) {
        return text.replace("\n\n", " ");
    }
}
