package sicher

import dev.fritz2.lenses.Lens
import dev.fritz2.lenses.buildLens
// import dev.fritz2.styling.theme.IconDefinition

/* TEST */
data class Names(
    val id: Int,
    val text: String
)
/* End */

data class NavIndex(
    var index: Int = 0
)

data class QuestionnaireData(
    val user: User = User(),
    val agency: Agency = Agency(),
    val questions: MutableList<Question> = mutableListOf(),
    val currentQuestionIndex: Int = 0
)


data class User(
    val name: String = "",
    val yearOfBirth: Int = 1900,
    val email: String = ""
)


data class Agency(
    val nummer: String = "",
    val strasse: String = "",
    val fax: String = "",
    val email: String = "",
    val hpName: String = "",
    val tel: String = "",
    val name: String = "",
    val ort: String = "",
    val plz: String = "",
    val kanalType: String = "",
    val firma: String = ""
)


data class Question(
    val index: Int,
    // val icon: IconDefinition,
    val name: String,
    val textVariants: TextVariants,
    val answerOptions: AnswerOptions,
    val previousIndex: Int = 0,
    val currentIndex: Int = 0,
    val nextIndex: Int = 0
)


data class TextVariants(
    val young: String,
    val personal: String,
    val formal: String
)


data class AnswerOptions(
    val type: String,
    val expected: String,
    val items: List<SelectItem>?
)


data class SelectItem(
    val index: String = "",
    val selected: Boolean = false,
    // val icon: IconDefinition,
    val name: String = "",
    val textVariants: TextVariants,
    val points: Points
)


data class Points(
    val f: Int = 0,
    val g: Int = 0,
    val h: Int = 0,
    val i: Int = 0,
    val j: Int = 0,
    val k: Int = 0,
    val l: Int = 0,
    val m: Int = 0,
    val n: Int = 0,
    val o: Int = 0,
    val p: Int = 0,
    val q: Int = 0,
    val r: Int = 0,
    val s: Int = 0,
    val t: Int = 0,
    val u: Int = 0,
    val v: Int = 0,
    val w: Int = 0,
    val x: Int = 0,
    val y: Int = 0,
    val z: Int = 0,
    val aa: Int = 0,
    val ab: Int = 0,
    val ac: Int = 0,
    val ad: Int = 0,
    val ae: Int = 0,
    val af: Int = 0,
    val ag: Int = 0,
    val ah: Int = 0,
    val ai: Int = 0,
    val aj: Int = 0,
    val ak: Int = 0,
    val al: Int = 0,
    val am: Int = 0,
    val an: Int = 0
)

/* "Semi-manually" created lenses */

object L {
    object Agency {
        val email: Lens<sicher.Agency, String> = buildLens("email", { it.email },{ p, v -> p.copy(email
        = v)})

        val fax: Lens<sicher.Agency, String> = buildLens("fax", { it.fax },{ p, v -> p.copy(fax = v)})

        val firma: Lens<sicher.Agency, String> = buildLens("firma", { it.firma },{ p, v -> p.copy(firma
        = v)})

        val hpName: Lens<sicher.Agency, String> = buildLens("hpName", { it.hpName },{ p, v ->
            p.copy(hpName = v)})

        val kanalType: Lens<sicher.Agency, String> = buildLens("kanalType", { it.kanalType },{ p, v ->
            p.copy(kanalType = v)})

        val name: Lens<sicher.Agency, String> = buildLens("name", { it.name },{ p, v -> p.copy(name =
        v)})

        val nummer: Lens<sicher.Agency, String> = buildLens("nummer", { it.nummer },{ p, v ->
            p.copy(nummer = v)})

        val ort: Lens<sicher.Agency, String> = buildLens("ort", { it.ort },{ p, v -> p.copy(ort = v)})

        val plz: Lens<sicher.Agency, String> = buildLens("plz", { it.plz },{ p, v -> p.copy(plz = v)})

        val strasse: Lens<sicher.Agency, String> = buildLens("strasse", { it.strasse },{ p, v ->
            p.copy(strasse = v)})

        val tel: Lens<sicher.Agency, String> = buildLens("tel", { it.tel },{ p, v -> p.copy(tel = v)})
    }

    object TextVariants {
        val formal: Lens<sicher.TextVariants, String> = buildLens("formal", { it.formal },{ p, v ->
            p.copy(formal = v)})

        val personal: Lens<sicher.TextVariants, String> = buildLens("personal", { it.personal },{ p,
                                                                                                       v -> p.copy(personal = v)})

        val young: Lens<sicher.TextVariants, String> = buildLens("young", { it.young },{ p, v ->
            p.copy(young = v)})
    }

    object User {
        val email: Lens<sicher.User, String> = buildLens("email", { it.email },{ p, v -> p.copy(email =
        v)})

        val name: Lens<sicher.User, String> = buildLens("name", { it.name },{ p, v -> p.copy(name = v)})

        val yearOfBirth: Lens<sicher.User, Int> = buildLens("yearOfBirth", { it.yearOfBirth },{ p, v ->
            p.copy(yearOfBirth = v)})
    }

    object Points {
        val aa: Lens<sicher.Points, Int> = buildLens("aa", { it.aa },{ p, v -> p.copy(aa = v)})

        val ab: Lens<sicher.Points, Int> = buildLens("ab", { it.ab },{ p, v -> p.copy(ab = v)})

        val ac: Lens<sicher.Points, Int> = buildLens("ac", { it.ac },{ p, v -> p.copy(ac = v)})

        val ad: Lens<sicher.Points, Int> = buildLens("ad", { it.ad },{ p, v -> p.copy(ad = v)})

        val ae: Lens<sicher.Points, Int> = buildLens("ae", { it.ae },{ p, v -> p.copy(ae = v)})

        val af: Lens<sicher.Points, Int> = buildLens("af", { it.af },{ p, v -> p.copy(af = v)})

        val ag: Lens<sicher.Points, Int> = buildLens("ag", { it.ag },{ p, v -> p.copy(ag = v)})

        val ah: Lens<sicher.Points, Int> = buildLens("ah", { it.ah },{ p, v -> p.copy(ah = v)})

        val ai: Lens<sicher.Points, Int> = buildLens("ai", { it.ai },{ p, v -> p.copy(ai = v)})

        val aj: Lens<sicher.Points, Int> = buildLens("aj", { it.aj },{ p, v -> p.copy(aj = v)})

        val ak: Lens<sicher.Points, Int> = buildLens("ak", { it.ak },{ p, v -> p.copy(ak = v)})

        val al: Lens<sicher.Points, Int> = buildLens("al", { it.al },{ p, v -> p.copy(al = v)})

        val am: Lens<sicher.Points, Int> = buildLens("am", { it.am },{ p, v -> p.copy(am = v)})

        val an: Lens<sicher.Points, Int> = buildLens("an", { it.an },{ p, v -> p.copy(an = v)})

        val f: Lens<sicher.Points, Int> = buildLens("f", { it.f },{ p, v -> p.copy(f = v)})

        val g: Lens<sicher.Points, Int> = buildLens("g", { it.g },{ p, v -> p.copy(g = v)})

        val h: Lens<sicher.Points, Int> = buildLens("h", { it.h },{ p, v -> p.copy(h = v)})

        val i: Lens<sicher.Points, Int> = buildLens("i", { it.i },{ p, v -> p.copy(i = v)})

        val j: Lens<sicher.Points, Int> = buildLens("j", { it.j },{ p, v -> p.copy(j = v)})

        val k: Lens<sicher.Points, Int> = buildLens("k", { it.k },{ p, v -> p.copy(k = v)})

        val l: Lens<sicher.Points, Int> = buildLens("l", { it.l },{ p, v -> p.copy(l = v)})

        val m: Lens<sicher.Points, Int> = buildLens("m", { it.m },{ p, v -> p.copy(m = v)})

        val n: Lens<sicher.Points, Int> = buildLens("n", { it.n },{ p, v -> p.copy(n = v)})

        val o: Lens<sicher.Points, Int> = buildLens("o", { it.o },{ p, v -> p.copy(o = v)})

        val p: Lens<sicher.Points, Int> = buildLens("p", { it.p },{ p, v -> p.copy(p = v)})

        val q: Lens<sicher.Points, Int> = buildLens("q", { it.q },{ p, v -> p.copy(q = v)})

        val r: Lens<sicher.Points, Int> = buildLens("r", { it.r },{ p, v -> p.copy(r = v)})

        val s: Lens<sicher.Points, Int> = buildLens("s", { it.s },{ p, v -> p.copy(s = v)})

        val t: Lens<sicher.Points, Int> = buildLens("t", { it.t },{ p, v -> p.copy(t = v)})

        val u: Lens<sicher.Points, Int> = buildLens("u", { it.u },{ p, v -> p.copy(u = v)})

        val v: Lens<sicher.Points, Int> = buildLens("v", { it.v },{ p, v -> p.copy(v = v)})

        val w: Lens<sicher.Points, Int> = buildLens("w", { it.w },{ p, v -> p.copy(w = v)})

        val x: Lens<sicher.Points, Int> = buildLens("x", { it.x },{ p, v -> p.copy(x = v)})

        val y: Lens<sicher.Points, Int> = buildLens("y", { it.y },{ p, v -> p.copy(y = v)})

        val z: Lens<sicher.Points, Int> = buildLens("z", { it.z },{ p, v -> p.copy(z = v)})
    }

    object SelectItem {
        val index: Lens<sicher.SelectItem, String> = buildLens("index", { it.index },{ p, v ->
            p.copy(index = v)})

        val name: Lens<sicher.SelectItem, String> = buildLens("name", { it.name },{ p, v -> p.copy(name
        = v)})

        val points: Lens<sicher.SelectItem, sicher.Points> = buildLens("points", { it.points },{ p, v ->
            p.copy(points = v)})

        val selected: Lens<sicher.SelectItem, Boolean> = buildLens("selected", { it.selected },{ p, v ->
            p.copy(selected = v)})

        // val icon: Lens<sicher.SelectItem, IconDefinition> = buildLens("icon", { it.icon },{ p, v ->
        //     p.copy(icon = v)})

        val textVariants: Lens<sicher.SelectItem, sicher.TextVariants> = buildLens("textVariants", {
            it.textVariants },{ p, v -> p.copy(textVariants = v)})
    }

    object NavIndex {
        val index: Lens<sicher.NavIndex, Int> = buildLens("index", { it.index },{ p, v -> p.copy(index =
        v)})
    }

    object Question {
        val answerOptions: Lens<sicher.Question, sicher.AnswerOptions> = buildLens("answerOptions", {
            it.answerOptions },{ p, v -> p.copy(answerOptions = v)})

        val currentIndex: Lens<sicher.Question, Int> = buildLens("currentIndex", { it.currentIndex },{
                p, v -> p.copy(currentIndex = v)})

        val index: Lens<sicher.Question, Int> = buildLens("index", { it.index },{ p, v -> p.copy(index =
        v)})

        // val icon: Lens<sicher.Question, IconDefinition> = buildLens("icon", { it.icon },{ p, v ->
        //    p.copy(icon = v)})

        val name: Lens<sicher.Question, String> = buildLens("name", { it.name },{ p, v -> p.copy(name =
        v)})

        val nextIndex: Lens<sicher.Question, Int> = buildLens("nextIndex", { it.nextIndex },{ p, v ->
            p.copy(nextIndex = v)})

        val previousIndex: Lens<sicher.Question, Int> = buildLens("previousIndex", { it.previousIndex
        },{ p, v -> p.copy(previousIndex = v)})

        val textVariants: Lens<sicher.Question, sicher.TextVariants> = buildLens("textVariants", {
            it.textVariants },{ p, v -> p.copy(textVariants = v)})
    }

    object QuestionnaireData {
        val agency: Lens<sicher.QuestionnaireData, sicher.Agency> = buildLens("agency", { it.agency },{
                p, v -> p.copy(agency = v)})

        val questions: Lens<sicher.QuestionnaireData, MutableList<sicher.Question>> =
            buildLens("questions", { it.questions },{ p, v -> p.copy(questions = v)})

        val currentQuestionIndex: Lens<sicher.QuestionnaireData,Int> = buildLens("currentQuestionIndex",{ it.currentQuestionIndex },{p,v -> p.copy(currentQuestionIndex = v)})

        val user: Lens<sicher.QuestionnaireData, sicher.User> = buildLens("user", { it.user },{ p, v ->
            p.copy(user = v)})
    }

    object AnswerOptions {
        val expected: Lens<sicher.AnswerOptions, String> = buildLens("expected", { it.expected },{ p, v ->
            p.copy(expected = v)})

        val items: Lens<sicher.AnswerOptions, List<sicher.SelectItem>?> = buildLens("items", { it.items
        },{ p, v -> p.copy(items = v)})

        val type: Lens<sicher.AnswerOptions, String> = buildLens("type", { it.type },{ p, v ->
            p.copy(type = v)})
    }

    object Names {
        val id: Lens<sicher.Names, Int> = buildLens("id", { it.id },{ p,v -> p.copy(id = v)})
        val text: Lens<sicher.Names, String> = buildLens("text", { it.text },{p,v -> p.copy(text = v) })
    }
}
