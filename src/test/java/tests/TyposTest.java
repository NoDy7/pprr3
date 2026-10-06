package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TyposPage;

import java.util.List;

public class TyposTest extends BaseTest {

    // The page randomly renders one of two variants of the sentence
    // (sometimes with a typo -- "paragraph" -> "paragraph" vs "paragraph").
    // We assert against the set of known acceptable variants rather than
    // a single exact string, since the content is intentionally unstable.
    private static final List<String> ACCEPTABLE_VARIANTS = List.of(
            "This is a sample paragraph. It's not too interesting, but the text is validation-worthy none-the-less.",
            "This is a sample paragraph. It's not too interesting, but the text is validation-wrothy none-the-less."
    );

    @Test(description = "Verify the paragraph text matches one of the acceptable (typo/non-typo) variants")
    public void verifyParagraphTextAgainstKnownVariants() {
        TyposPage page = new TyposPage(driver).openPage();

        String actualText = page.getParagraphText();
        Assert.assertTrue(ACCEPTABLE_VARIANTS.contains(actualText),
                "Unexpected paragraph text (site content is known to vary): " + actualText);
    }
}
