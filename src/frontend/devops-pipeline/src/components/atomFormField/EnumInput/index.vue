<template>
    <form>
        <bk-radio-group @change="handleSelect" :value="value" :name="name">
            <template v-for="item in list">
                <bk-popover v-if="!item.hidden" :disabled="!item.tips" :key="item.id" :content="item.tips">
                    <bk-radio class="bkdevops-radio" :style="`width: calc(${100 / lineNumber}% - 10px)`" :value="item.value" :disabled="disabled || item.disabled">
                        <span class="overflow" v-bk-overflow-tips>{{ item.label }}</span>
                    </bk-radio>
                </bk-popover>
            </template>
        </bk-radio-group>
    </form>
</template>

<script>
    import atomFieldMixin from '../atomFieldMixin'
    export default {
        name: 'enum-input',
        mixins: [atomFieldMixin],
        props: {
            list: {
                type: Array,
                default: []
            },
            lineNumber: {
                type: Number,
                default: 0
            },
            value: [Number, Boolean, String]
        },
        methods: {
            handleSelect (value) {
                if (value === 'true') {
                    value = true
                } else if (value === 'false') {
                    value = false
                }
                this.handleChange(this.name, value)
            }
        }
    }
</script>

<style lang="scss" scoped>
    .bkdevops-radio {
        margin-right: 10px;
        /deep/ .bk-radio-text {
            width: calc(100% - 21px);
            height: 20px;
            line-height: 20px;
        }
        .overflow {
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            width: 100%;
            display: inline-block;
        }
    }
</style>
