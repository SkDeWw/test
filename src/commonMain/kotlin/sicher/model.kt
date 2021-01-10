package sicher

import dev.fritz2.lenses.Lenses
import dev.fritz2.styling.theme.IconDefinition

@Lenses
data class QuestionnaireData(
    var user: User = User(),
    var agency: Agency = Agency(),
    var questions: MutableList<Question> = mutableListOf()
)

@Lenses
data class User(
    var name: String = "",
    var yearOfBirth: Int = 1900,
    var email: String = ""
)

@Lenses
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

@Lenses
data class Question(
    val index: Int,
    val icon: IconDefinition,
    val name: String,
    val textVariants: TextVariants,
    val answerOptions: AnswerOptions,
    val previousIndex: Int,
    val currentIndex: Int,
    val nextIndex: Int
)

@Lenses
data class TextVariants(
    val young: String,
    val personal: String,
    val formal: String
)

@Lenses
data class AnswerOptions(
    val type: String,
    val expected: String,
    val items: List<SelectItem>?
)

@Lenses
data class SelectItem(
    val index: String = "",
    val selected: Boolean = false,
    val icon: IconDefinition,
    val name: String = "",
    val textVariants: TextVariants,
    val points: Points
)

@Lenses
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


