package sicher

import dev.fritz2.binding.*
import dev.fritz2.dom.html.render
import dev.fritz2.dom.mount
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

/* Model */
var myModel : QuestionnaireData = QuestionnaireData(questions = mutableListOf(
    Question(
        1,
        "name",
        TextVariants("Wie ist Dein Name", "Wie ist Dein Name", "Wie ist Ihr Name"),
        AnswerOptions("input", "text", null)
    ),
    Question(
        2,
        "age",
        TextVariants("Wie alt bist Du?", "Wie alt bist Du?", "Wie alt sind Sie?"),
        AnswerOptions("input", "text", null)
    )
))

/* Stores */
object QuestionnaireStore : RootStore<QuestionnaireData>(myModel,id="questionnaireData"){}

object NamesStore : RootStore<List<Names>>(listOf(Names(1,"Fritz"),Names(2,"Karl"),Names(3,"Otto")),"namesStore"){}

object NavIndexStore : RootStore<Int>(0,"navIndexStore"){
    var increase = handle { model,action: Int ->
        console.log("NavIndexStore.increase mit model=$model und action=$action")
        model+1
    }
    var decrease = handle { model,action: Int ->
        console.log("NavIndexStore.decrease mit model=$model und action=$action")
        model-1
    }
}



@ExperimentalCoroutinesApi
@FlowPreview
fun main() {
    val filteredNamesFlow = NamesStore.data.combine(NavIndexStore.data){ names, id ->
        names.filter { it.id == id }
    }
    val questionsSubStore = QuestionnaireStore.sub(L.QuestionnaireData.questions)
    val filteredQuestionsFlow = questionsSubStore.data.combine(NavIndexStore.data){ questions, id ->
        questions.filter { it.index == id }
    }

    render {
        div {
            h3 {
                +"Verfügbare Namen:"
            }
            ul {
                NamesStore.data.renderEach { n ->
                    li {
                        +n.id.toString()
                        +": "
                        +n.text
                    }
                }
            }
        }
        div {
            h3 {
                +"Verfügbare Fragen:"
            }
            ul {
                questionsSubStore.data.renderEach { q ->
                    li {
                        +q.textVariants.personal
                    }
                }
            }
        }
        hr {  }
        div {
            h3 {
                +"Zugriff auf die Liste via Index"
            }
            p{
                filteredNamesFlow.renderEach(Names::id){ name ->
                    val focusedNameStore = storeOf(name)
                    val focusedNameTextStore = focusedNameStore.sub(L.Names.text)
                    span {
                        focusedNameTextStore.data.map { "Hallo $it!" }.asText()
                    }
                }
            }
            p {
                filteredQuestionsFlow.renderEach(Question::index){ q ->
                    val focusedQuestionStore = storeOf(q)
                    val focusedQuestionTextVariantsSubStore = focusedQuestionStore.sub(L.Question.textVariants)
                    val focusedQuestionPersonalVariantSubStore = focusedQuestionTextVariantsSubStore.sub(L.TextVariants.personal)
                    span {
                        focusedQuestionPersonalVariantSubStore.data.map { "Frage: $it" }.asText()
                    }
                }
            }
            button("default-state") {
                +"zurück"
                clicks.events.map { 1 } handledBy NavIndexStore.decrease
            }
            button("default-state") {
                +"vor"
                clicks.events.map { 1 } handledBy NavIndexStore.increase
            }
            p {
                +"NavIndexStore.data.asText() = "
                NavIndexStore.data.asText()
            }
        }

    }.mount("target")
}



