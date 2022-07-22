import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.ksp.writeTo
import kotlin.reflect.KClass

class FastJsonProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        FastJsonProcessor(environment)
}

class FastJsonProcessor(
    private val environment: SymbolProcessorEnvironment
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val fastJsonVisitor = FastJsonVisitor(environment.codeGenerator)

        resolver.forEach<KSFunctionDeclaration>(JsonType::class) {
            it.accept(fastJsonVisitor, Unit)
        }

        return emptyList()
    }
}

class FastJsonVisitor(
    private val codeGenerator: CodeGenerator
) : KSVisitorVoid() {
    override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
        val packageName = function.packageName.getShortName()
        val type = function.returnType?.resolve()?.declaration ?: throw IllegalStateException("Return type could not be recovered")
        val name = type.simpleName.getShortName()

        FileSpec.builder(packageName, name).apply {
            addFileComment("Hello World")
        }.build().writeTo(codeGenerator, Dependencies(false))
    }
}

val parser = Parser::class.asClassName()

inline fun <reified T : Any> Resolver.forEach(clazz: KClass<*>, consumer: (T) -> Unit) =
    getSymbolsWithAnnotation(clazz.qualifiedName!!).forEachInstance(consumer)

inline fun <reified T : Any> Sequence<Any>.forEachInstance(consumer: (T) -> Unit) =
    forEach {
        if (it is T) consumer(it)
    }